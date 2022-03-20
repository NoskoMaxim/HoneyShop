package honeyshop.adapter.user;

import honeyshop.dto.user.UserDto;
import honeyshop.dto.user.UserRoleDto;
import honeyshop.dto.user.UserToUpdateFormDto;
import honeyshop.model.user.User;
import honeyshop.model.user.role.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserAdapterTest {

    UserAdapter userAdapter;

    @BeforeEach
    void setUp() {
        userAdapter = new UserAdapter();
    }

    @Test
    void itShouldGetUserDto() {
        //Arrange
        User user = new User();
        user.setUserId(1L);
        user.setUsername("Max");
        user.setFirstName("Max");
        user.setLastName("MaxMax");
        user.setEmail("Max@haha.com");
        user.setPhone("+111111");
        user.setRoles(List.of(
                new UserRole(
                        1L,
                        "USER"
                ),
                new UserRole(
                        1L,
                        "USER"
                )
        ));

        //Act
        UserDto expected = userAdapter.getUserDto(user);

        //Assert
        assertEquals(expected.getUserId(), 1L);
        assertEquals(expected.getUsername(), "Max");
        assertEquals(expected.getFirstName(), "Max");
        assertEquals(expected.getLastName(), "MaxMax");
        assertEquals(expected.getEmail(), "Max@haha.com");
        assertEquals(expected.getPhone(), "+111111");
        expected.getRoles().forEach(role -> {
            assertEquals(role.getRoleId(), 1L);
            assertEquals(role.getRoleName(), "USER");
        });
    }

    @Test
    void itShouldGetUserDtoList() {
        //Arrange
        List<User> users = List.of(
                new User(
                        1L,
                        "Max",
                        "Max",
                        "Max",
                        "Max",
                        "Max@ahah.com",
                        "+111111",
                        List.of(
                                new UserRole(
                                        1L,
                                        "USER"
                                ),
                                new UserRole(
                                        1L,
                                        "USER"
                                )
                        )
                ),
                new User(
                        1L,
                        "Max",
                        "Max",
                        "Max",
                        "Max",
                        "Max@ahah.com",
                        "+111111",
                        List.of(
                                new UserRole(
                                        1L,
                                        "USER"
                                ),
                                new UserRole(
                                        1L,
                                        "USER"
                                )
                        )
                )
        );

        //Act
        List<UserDto> expectedList = userAdapter.getUserDtoList(users);

        //Assert
        expectedList.forEach(expected -> {
            assertEquals(expected.getUserId(), 1L);
            assertEquals(expected.getUsername(), "Max");
            assertEquals(expected.getFirstName(), "Max");
            assertEquals(expected.getLastName(), "Max");
            assertEquals(expected.getEmail(), "Max@ahah.com");
            assertEquals(expected.getPhone(), "+111111");
            expected.getRoles().forEach(role -> {
                assertEquals(role.getRoleId(), 1L);
                assertEquals(role.getRoleName(), "USER");
            });
        });
    }

    @Test
    void itShouldNotGetUserDto() {
        //Arrange
        User user = new User();
        user.setUserId(1L);
        user.setUsername("Max");
        user.setFirstName("Max");
        user.setLastName("MaxMax");
        user.setEmail("Max@haha.com");
        user.setPhone("+111111");
        user.setRoles(List.of(
                new UserRole(
                        1L,
                        "USER"
                ),
                new UserRole(
                        1L,
                        "USER"
                )
        ));

        //Act
        UserDto expected = userAdapter.getUserDto(user);

        //Assert
        assertNotEquals(expected.getUserId(), 2L);
        assertNotEquals(expected.getUsername(), "NoMax");
        assertNotEquals(expected.getFirstName(), "NoMax");
        assertNotEquals(expected.getLastName(), "NoMaxMax");
        assertNotEquals(expected.getEmail(), "NoMax@haha.com");
        assertNotEquals(expected.getPhone(), "+No111111");
        expected.getRoles().forEach(role -> {
            assertNotEquals(role.getRoleId(), 2L);
            assertNotEquals(role.getRoleName(), "ADMIN");
        });
    }

    @Test
    void itShouldNotGetUserDtoList() {
        //Arrange
        List<User> users = List.of(
                new User(
                        1L,
                        "Max",
                        "Max",
                        "Max",
                        "Max",
                        "Max@ahah.com",
                        "+111111",
                        List.of(
                                new UserRole(
                                        1L,
                                        "USER"
                                ),
                                new UserRole(
                                        1L,
                                        "USER"
                                )
                        )
                ),
                new User(
                        1L,
                        "Max",
                        "Max",
                        "Max",
                        "Max",
                        "Max@ahah.com",
                        "+111111",
                        List.of(
                                new UserRole(
                                        1L,
                                        "USER"
                                ),
                                new UserRole(
                                        1L,
                                        "USER"
                                )
                        )
                )
        );

        //Act
        List<UserDto> expectedList = userAdapter.getUserDtoList(users);

        //Assert
        expectedList.forEach(expected -> {
            assertNotEquals(expected.getUserId(), 2L);
            assertNotEquals(expected.getUsername(), "MaxMax");
            assertNotEquals(expected.getFirstName(), "MaxMax");
            assertNotEquals(expected.getLastName(), "MaxMax");
            assertNotEquals(expected.getEmail(), "Max@ahah..com");
            assertNotEquals(expected.getPhone(), "+1111111");
            expected.getRoles().forEach(role -> {
                assertNotEquals(role.getRoleId(), 2L);
                assertNotEquals(role.getRoleName(), "ADMIN");
            });
        });
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
        assertNull(expected.getPassword());
        assertEquals(expected.getFirstName(), "Max");
        assertEquals(expected.getLastName(), "MaxMax");
        assertEquals(expected.getEmail(), "Max@haha.com");
        assertEquals(expected.getPhone(), "+111111");
        assertEquals(expected.getRoles(), new ArrayList<>());
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
        assertNotEquals(expected.getUsername(), "MaxMax");
        assertNull(expected.getPassword());
        assertNotEquals(expected.getFirstName(), "MaxMax");
        assertNotEquals(expected.getLastName(), "MaxMaxMax");
        assertNotEquals(expected.getEmail(), "Maxx@haha.com");
        assertNotEquals(expected.getPhone(), "+1112111");
        assertEquals(expected.getRoles(), new ArrayList<>());
    }

    @Test
    void itShouldGetUserRoleDto() {
        //Arrange
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setRoleName("USER");

        //Act
        UserRoleDto expected = userAdapter.getUserRoleDto(userRole);

        //Assert
        assertEquals(expected.getRoleId(), 1L);
        assertEquals(expected.getUserName(), "USER");
    }

    @Test
    void itShouldGetUserRoleDtoList() {
        //Arrange
        List<UserRole> userRoles = List.of(
                new UserRole(
                        1L,
                        "USER"
                ),
                new UserRole(
                        1L,
                        "USER"
                )
        );

        //Act
        List<UserRoleDto> expectedList = userAdapter.getUserRoleDtoList(userRoles);

        //Assert
        expectedList.forEach(expected -> {
            assertEquals(expected.getRoleId(), 1L);
            assertEquals(expected.getUserName(), "USER");
        });
    }

    @Test
    void itShouldNotGetUserRoleDto() {
        //Arrange
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setRoleName("USER");

        //Act
        UserRoleDto expected = userAdapter.getUserRoleDto(userRole);

        //Assert
        assertNotEquals(expected.getRoleId(), 2L);
        assertNotEquals(expected.getUserName(), "ADMIN");
    }

    @Test
    void itShouldNotGetUserRoleDtoList() {
        //Arrange
        List<UserRole> userRoles = List.of(
                new UserRole(
                        1L,
                        "USER"
                ),
                new UserRole(
                        1L,
                        "USER"
                )
        );

        //Act
        List<UserRoleDto> expectedList = userAdapter.getUserRoleDtoList(userRoles);

        //Assert
        expectedList.forEach(expected -> {
            assertNotEquals(expected.getRoleId(), 2L);
            assertNotEquals(expected.getUserName(), "ADMIN");
        });
    }
}