package honeyshop.service.user;

import honeyshop.dto.user.RoleToUserFormDto;
import honeyshop.dto.user.UserDto;
import honeyshop.dto.user.UserRoleDto;
import honeyshop.dto.user.UsernameAndPasswordToCreateFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {
    void createUser(UsernameAndPasswordToCreateFormDto createForm);

    UserDto getUserByUsername(String username);

    List<UserDto> getAllUsers();

    void createRole(String roleName);

    List<UserRoleDto> getAllRoles();

    void addRoleToUser(RoleToUserFormDto roleToUserFormDto);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

    void updateRole(UserRoleDto roleDto);

    void deleteRole(Long roleId);
}
