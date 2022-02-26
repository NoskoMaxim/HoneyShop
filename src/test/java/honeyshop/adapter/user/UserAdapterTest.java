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
    void itShouldGetUser() {
        //Arrange
        UserToUpdateFormDto userDto = new UserToUpdateFormDto();
        userDto.setUserId(1L);
        userDto.setUsername("Max");
        userDto.setFirstName("Max");
        userDto.setLastName("MaxMax");
        userDto.setEmail("Max@haha.com");
        userDto.setPhone("+111111");

        //Act
        User expected = userAdapter.getUser(userDto);

        //Assert
        assertEquals(expected.getUserId(), 1L);
        assertEquals(expected.getUsername(), "Max");
        assertEquals(expected.getFirstName(), "Max");
        assertEquals(expected.getLastName(), "MaxMax");
        assertEquals(expected.getEmail(), "Max@haha.com");
        assertEquals(expected.getPhone(), "+111111");
    }

    @Test
    void itShouldNotGetUser() {
        //Arrange
        UserToUpdateFormDto userDto = new UserToUpdateFormDto();
        userDto.setUserId(1L);
        userDto.setUsername("Max");
        userDto.setFirstName("Max");
        userDto.setLastName("MaxMax");
        userDto.setEmail("Max@haha.com");
        userDto.setPhone("+111111");

        //Act
        User expected = userAdapter.getUser(userDto);

        //Assert
        assertNotEquals(expected.getUserId(), 2L);
        assertNotEquals(expected.getUsername(), "Maxx");
        assertNotEquals(expected.getFirstName(), "Maxx");
        assertNotEquals(expected.getLastName(), "MaxMaxx");
        assertNotEquals(expected.getEmail(), "Maxx@haha.com");
        assertNotEquals(expected.getPhone(), "+1112111");
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