package honeyshop.service.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.user.RoleToUserFormDto;
import honeyshop.dto.user.UserDto;
import honeyshop.dto.user.UserRoleDto;
import honeyshop.dto.user.UsernameAndPasswordToCreateFormDto;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;
import honeyshop.repository.role.RoleRepos;
import honeyshop.repository.user.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepos userRepos;
    private final RoleRepos roleRepos;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepos userRepos, RoleRepos roleRepos, PasswordEncoder passwordEncoder) {
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
            throw new HoneyShopException(failures);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.get().getRoles().forEach(role -> authorities
                .add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(),
                user.get().getPassword(),
                authorities);
    }

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
            throw new HoneyShopException(failures);
        }
    }

    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepos.findUserByUsername(username);
        if (user.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put("UsernameException", "Username does not exist");
            throw new HoneyShopException(failures);
        }
        return convertUserToUserDto(user.get());
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepos.findAll();
        return convertUserListToUserDtoList(users);
    }

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
            throw new HoneyShopException(failures);
        }
    }

    public List<UserRoleDto> getAllRoles() {
        List<UserRole> roles = roleRepos.findAll();
        return convertUserRoleListToUserRoleDto(roles);
    }

    public void addRoleToUser(RoleToUserFormDto roleToUserFormDto) {
        Optional<User> user = userRepos.findUserByUsername(roleToUserFormDto.getUsername());
        Optional<UserRole> role = roleRepos.findUserRoleByName(roleToUserFormDto.getRoleName());
        if (user.isEmpty() || role.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put(
                    "UsernameOrRoleNameNotFoundException",
                    "Username or Role name does not exist");
            throw new HoneyShopException(failures);
        }
        user.get().getRoles().add(role.get());
        userRepos.save(user.get());
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());   //FIXME fix .length()
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
            } catch (Exception exception) {
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
            throw new HoneyShopException(failures);
        }
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhone(user.getPhone());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

    private List<UserDto> convertUserListToUserDtoList(List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach(user -> usersDto.add(convertUserToUserDto(user)));
        return usersDto;
    }

    private UserRoleDto convertUserRoleToUserRoleDto(UserRole role) {
        UserRoleDto roleDto = new UserRoleDto();
        roleDto.setRoleId(role.getRoleId());
        roleDto.setRoleName(role.getName());
        return roleDto;
    }

    private List<UserRoleDto> convertUserRoleListToUserRoleDto(List<UserRole> roles) {
        List<UserRoleDto> rolesDto = new ArrayList<>();
        roles.forEach(role -> rolesDto.add(convertUserRoleToUserRoleDto(role)));
        return rolesDto;
    }
}
