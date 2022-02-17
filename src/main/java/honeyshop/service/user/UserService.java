package honeyshop.service.user;

import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.user.RoleToUserForm;
import honeyshop.dto.user.UserDto;
import honeyshop.dto.user.UserRoleDto;
import honeyshop.dto.user.UsernameAndPasswordToCreateForm;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;
import honeyshop.repository.role.RoleRepo;
import honeyshop.repository.user.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepos userRepos;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepos userRepos, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepos = userRepos;
        this.roleRepo = roleRepo;
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

    public void createUser(UsernameAndPasswordToCreateForm createForm) {
        User user = new User();
        user.setUsername(createForm.getUsername());
        user.setPassword(passwordEncoder.encode(createForm.getPassword()));
        try {
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
            roleRepo.save(role);
        } catch (DataIntegrityViolationException exception) {
            Map<String, String> failures = new HashMap<>();
            failures.put(
                    "RoleNameException",
                    "Role with name " + roleName + " already exists");
            throw new HoneyShopException(failures);
        }
    }

    public List<UserRoleDto> getAllRoles() {
        List<UserRole> roles = roleRepo.findAll();
        return convertUserRoleListToUserRoleDto(roles);
    }

    public void addRoleToUser(RoleToUserForm roleToUserForm) {
        Optional<User> user = userRepos.findUserByUsername(roleToUserForm.getUsername());
        Optional<UserRole> role = roleRepo.findUserRoleByName(roleToUserForm.getRoleName());
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
