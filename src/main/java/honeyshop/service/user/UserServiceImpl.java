package honeyshop.service.user;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import honeyshop.adapter.user.*;
import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.user.*;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;
import honeyshop.repository.role.RoleRepos;
import honeyshop.repository.user.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.*;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepos userRepos;
    private final RoleRepos roleRepos;
    private final PasswordEncoder passwordEncoder;
    private final UserAdapter userAdapter = new UserAdapterImpl();

    @Autowired
    public UserServiceImpl(UserRepos userRepos, RoleRepos roleRepos, PasswordEncoder passwordEncoder) {
        this.userRepos = userRepos;
        this.roleRepos = roleRepos;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepos.findUserByUsername(username);
        if (user.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put("UsernameException", "Username does not exist");
            throw new HoneyShopException(failures, NO_CONTENT);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.get().getRoles().forEach(role -> authorities
                .add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(),
                user.get().getPassword(),
                authorities);
    }

    @Override
    public void createUser(UsernameAndPasswordToCreateFormDto createForm) {
        User user = new User();
        user.setUsername(createForm.getUsername());
        user.setPassword(passwordEncoder.encode(createForm.getPassword()));
        try {
            userRepos.save(user);
            user = userRepos.findUserByUsername(createForm.getUsername()).get();
            user.getRoles().add(roleRepos.findUserRoleByName("USER").get());
            userRepos.save(user);
        } catch (DataIntegrityViolationException exception) {
            Map<String, String> failures = new HashMap<>();
            failures.put("UsernameException", "Username already exists");
            throw new HoneyShopException(failures, BAD_REQUEST);
        }
    }

    @Override
    public void updateUser(UserToUpdateFormDto userDto) {
        Optional<User> userOptional = userRepos.findById(userDto.getUserId());
        if (userOptional.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put("UserException", "User does not exist");
            throw new HoneyShopException(failures, NO_CONTENT);
        }
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userOptional.get().getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setRoles(userOptional.get().getRoles());
        userRepos.save(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepos.findUserByUsername(username);
        if (user.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put("UsernameException", "Username does not exist");
            throw new HoneyShopException(failures, NO_CONTENT);
        }
        return userAdapter.getUserDto(user.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepos.findAll();
        return userAdapter.getUserDtoList(users);
    }

    @Override
    public void createRole(String roleName) {
        UserRole role = new UserRole();
        role.setName(roleName);
        try {
            roleRepos.save(role);
        } catch (DataIntegrityViolationException exception) {
            Map<String, String> failures = new HashMap<>();
            failures.put(
                    "RoleNameException",
                    "Role with name " + roleName + " already exists");
            throw new HoneyShopException(failures, BAD_REQUEST);
        }
    }

    @Override
    public void updateRole(UserRoleDto roleDto) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleDto.getRoleId());
        userRole.setName(roleDto.getUserName());
        roleRepos.save(userRole);
    }

    @Override
    public void deleteRole(Long roleId) {
        try {
            roleRepos.deleteById(roleId);
        } catch (EmptyResultDataAccessException psqlException) {
            Map<String, String> failures = new HashMap<>();
            failures.put("NotFoundRoleException", "Role does not exist");
            throw new HoneyShopException(failures, GONE);
        }
    }

    @Override
    public List<UserRoleDto> getAllRoles() {
        List<UserRole> roles = roleRepos.findAll();
        return userAdapter.getUserRoleDtoList(roles);
    }

    @Override
    public void addRoleToUser(RoleToUserFormDto roleToUserFormDto) {
        Optional<User> user = userRepos.findUserByUsername(roleToUserFormDto.getUsername());
        Optional<UserRole> role = roleRepos.findUserRoleByName(roleToUserFormDto.getRoleName());
        if (user.isEmpty() || role.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put(
                    "UsernameOrRoleNameNotFoundException",
                    "Username or Role name does not exist");
            throw new HoneyShopException(failures, NO_CONTENT);
        }
        user.get().getRoles().add(role.get());
        userRepos.save(user.get());
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                User user = userRepos.findUserByUsername(username).get();
                String accessToken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 120 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream()
                                .map(UserRole::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", accessToken);
                tokens.put("refresh_token", refreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (JWTVerificationException exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("access_token", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            Map<String, String> failures = new HashMap<>();
            failures.put(
                    "RefreshTokenException",
                    "Refresh token is missing");
            throw new HoneyShopException(failures, UNAUTHORIZED);
        }
    }
}
