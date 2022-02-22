package honeyshop.adapter.user;

import honeyshop.dto.user.UserDto;
import honeyshop.dto.user.UserRoleDto;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;

import java.util.List;

public interface UserAdapter {
    UserDto getUserDto(User user);

    List<UserDto> getUserDtoList(List<User> users);

    UserRoleDto getUserRoleDto(UserRole role);

    List<UserRoleDto> getUserRoleDto(List<UserRole> roles);
}
