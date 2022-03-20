package honeyshop.adapter.user;

import honeyshop.dto.user.UserDto;
import honeyshop.dto.user.UserRoleDto;
import honeyshop.dto.user.UserToUpdateFormDto;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAdapter {
    ModelMapper userMapper = new ModelMapper();

    public UserDto getUserDto(User user) {
        TypeMap<User, UserDto> propertyMapper = this.userMapper.createTypeMap(User.class, UserDto.class);
        propertyMapper.addMappings(userMapper -> userMapper.skip(UserDto::setPassword));
        return userMapper.map(user, UserDto.class);
    }

    public User getUser(UserToUpdateFormDto userDto) {
        return userMapper.map(userDto,User.class);
    }

    public List<UserDto> getUserDtoList(List<User> users) {
        TypeMap<User, UserDto> propertyMapper = this.userMapper.createTypeMap(User.class, UserDto.class);
        propertyMapper.addMappings(userMapper -> userMapper.skip(UserDto::setPassword));
        return users.stream()
                .map(this::getUserDto)
                .collect(Collectors.toList());
    }

    public UserRoleDto getUserRoleDto(UserRole role) {
        return userMapper.map(role, UserRoleDto.class);
    }

    public List<UserRoleDto> getUserRoleDtoList(List<UserRole> roles) {
        return roles.stream()
                .map(this::getUserRoleDto)
                .collect(Collectors.toList());
    }
}
