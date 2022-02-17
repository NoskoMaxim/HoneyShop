package honeyshop.service.user;

import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.user.UserDto;
import honeyshop.model.user.User;
import honeyshop.model.user.UserRole;
import honeyshop.repository.user.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserService {

    private final UserRepos userRepos;

    @Autowired
    public UserService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    public void addUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        try {
            userRepos.save(user);
        } catch (DataIntegrityViolationException exception) {
            Map<String, String> failures = new HashMap<>();
            failures.put("UsernameException", "Username already exists");
            throw new HoneyShopException(failures);
        }
    }

    public void addRoleToUser(String username, UserRole userRole) {
        Optional<User> user = userRepos.findUserByUsername(username);
        if (user.isEmpty()){
            Map<String, String> failures = new HashMap<>();
            failures.put("UsernameException", "Username does not exist");
            throw new HoneyShopException(failures);
        }
        user.get().setRole(userRole);
        userRepos.save(user.get());
    }

    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepos.findUserByUsername(username);
        if (user.isEmpty()){
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

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhone(user.getPhone());
        userDto.setRole(user.getRole());
        return userDto;
    }

    private List<UserDto> convertUserListToUserDtoList(List<User> users){
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach(user -> usersDto.add(convertUserToUserDto(user)));
        return usersDto;
    }
}
