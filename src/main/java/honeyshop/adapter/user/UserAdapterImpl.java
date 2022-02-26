package honeyshop.adapter.user;

import honeyshop.dto.user.*;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;

import java.util.ArrayList;
import java.util.List;

public class UserAdapterImpl implements UserAdapter{
    @Override
    public UserDto getUserDto(User user) {
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

    @Override
    public User getUser(UserToUpdateFormDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        return user;
    }

    @Override
    public List<UserDto> getUserDtoList(List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach(user -> usersDto.add(getUserDto(user)));
        return usersDto;
    }

    @Override
    public UserRoleDto getUserRoleDto(UserRole role) {
        UserRoleDto roleDto = new UserRoleDto();
        roleDto.setRoleId(role.getRoleId());
        roleDto.setRoleName(role.getName());
        return roleDto;
    }

    @Override
    public List<UserRoleDto> getUserRoleDtoList(List<UserRole> roles) {
        List<UserRoleDto> rolesDto = new ArrayList<>();
        roles.forEach(role -> rolesDto.add(getUserRoleDto(role)));
        return rolesDto;
    }
}
