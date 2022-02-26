package honeyshop.adapter.user;

import honeyshop.dto.user.UserDto;
import honeyshop.dto.user.UserRoleDto;
import honeyshop.dto.user.UserToUpdateFormDto;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;

import java.util.List;

public interface UserAdapter {
    UserDto getUserDto(User user);

    User getUser(UserToUpdateFormDto userDto);

    List<UserDto> getUserDtoList(List<User> users);

    UserRoleDto getUserRoleDto(UserRole role);

    List<UserRoleDto> getUserRoleDtoList(List<UserRole> roles);
}
