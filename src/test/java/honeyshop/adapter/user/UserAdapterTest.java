package honeyshop.adapter.user;

import honeyshop.dto.user.*;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserAdapterTest {

    UserAdapter userAdapter;

    @BeforeEach
    void setUp() {
        userAdapter = new UserAdapterImpl();
    }

    @Test
    void itShouldGetUserDto() {
        //Arrange
        User user = new User();
        user.setUserId(1L);

        //Act
        UserDto expected = userAdapter.getUserDto(user);

        //Assert
        assertEquals(expected.getUserId(), 1L);
    }

    @Test
    void itShouldNotGetUserDto() {
        //Arrange
        User user = new User();
        user.setUserId(1L);

        //Act
        UserDto expected = userAdapter.getUserDto(user);

        //Assert
        assertNotEquals(expected.getUserId(), 2L);
    }

    @Test
    void itShouldGetUserRoleDto() {
        //Arrange
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setName("Max");

        //Act
        UserRoleDto expected = userAdapter.getUserRoleDto(userRole);

        //Assert
        assertEquals(expected.getRoleId(), 1L);
        assertEquals(expected.getUserName(), "Max");
    }

    @Test
    void itShouldNotGetUserRoleDto() {
        //Arrange
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setName("Max");

        //Act
        UserRoleDto expected = userAdapter.getUserRoleDto(userRole);

        //Assert
        assertNotEquals(expected.getRoleId(), 2L);
        assertNotEquals(expected.getUserName(), "Maxim");
    }
}