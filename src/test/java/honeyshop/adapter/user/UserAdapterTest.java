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
        user.setPassword("Max");
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
        UserDto actual = userAdapter.getUserDto(user);

        //Assert
        assertEquals(1L, actual.getUserId());
        assertEquals("Max", actual.getUsername());
        assertNull(actual.getPassword());
        assertEquals("Max", actual.getFirstName());
        assertEquals("MaxMax", actual.getLastName());
        assertEquals("Max@haha.com", actual.getEmail());
        assertEquals("+111111", actual.getPhone());
        actual.getRoles().forEach(role -> {
            assertEquals(1L, role.getRoleId());
            assertEquals("USER", role.getRoleName());
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
        List<UserDto> actualList = userAdapter.getUserDtoList(users);

        //Assert
        actualList.forEach(actual -> {
            assertEquals(1L, actual.getUserId());
            assertEquals("Max", actual.getUsername());
            assertNull(actual.getPassword());
            assertEquals("Max", actual.getFirstName());
            assertEquals("Max", actual.getLastName());
            assertEquals("Max@ahah.com", actual.getEmail());
            assertEquals("+111111", actual.getPhone());
            actual.getRoles().forEach(role -> {
                assertEquals(1L, role.getRoleId());
                assertEquals("USER", role.getRoleName());
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
        UserDto actual = userAdapter.getUserDto(user);

        //Assert
        assertNotEquals(2L, actual.getUserId());
        assertNotEquals("NoMax", actual.getUsername());
        assertNull(actual.getPassword());
        assertNotEquals("NoMax", actual.getFirstName());
        assertNotEquals("NoMaxMax", actual.getLastName());
        assertNotEquals("NoMax@haha.com", actual.getEmail());
        assertNotEquals("+No111111", actual.getPhone());
        actual.getRoles().forEach(role -> {
            assertNotEquals(2L, role.getRoleId());
            assertNotEquals("ADMIN", role.getRoleName());
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
        List<UserDto> actualList = userAdapter.getUserDtoList(users);

        //Assert
        actualList.forEach(actual -> {
            assertNotEquals(2L, actual.getUserId());
            assertNotEquals("MaxMax", actual.getUsername());
            assertNull(actual.getPassword());
            assertNotEquals("MaxMax", actual.getFirstName());
            assertNotEquals("MaxMax", actual.getLastName());
            assertNotEquals("Max@ahah..com", actual.getEmail());
            assertNotEquals("+1111111", actual.getPhone());
            actual.getRoles().forEach(role -> {
                assertNotEquals(2L, role.getRoleId());
                assertNotEquals("ADMIN", role.getRoleName());
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
        User actual = userAdapter.getUser(userDto);

        //Assert
        assertEquals(1L, actual.getUserId());
        assertEquals("Max", actual.getUsername());
        assertNull(actual.getPassword());
        assertEquals("Max", actual.getFirstName());
        assertEquals("MaxMax", actual.getLastName());
        assertEquals("Max@haha.com", actual.getEmail());
        assertEquals("+111111", actual.getPhone());
        assertEquals(new ArrayList<>(), actual.getRoles());
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
        User actual = userAdapter.getUser(userDto);

        //Assert
        assertNotEquals(2L, actual.getUserId());
        assertNotEquals("MaxMax", actual.getUsername());
        assertNull(actual.getPassword());
        assertNotEquals("MaxMax", actual.getFirstName());
        assertNotEquals("MaxMaxMax", actual.getLastName());
        assertNotEquals("Maxx@haha.com", actual.getEmail());
        assertNotEquals("+1112111", actual.getPhone());
        assertEquals(new ArrayList<>(), actual.getRoles());
    }

    @Test
    void itShouldGetUserRoleDto() {
        //Arrange
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setRoleName("USER");

        //Act
        UserRoleDto actual = userAdapter.getUserRoleDto(userRole);

        //Assert
        assertEquals(1L, actual.getRoleId());
        assertEquals("USER", actual.getUserName());
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
        List<UserRoleDto> actualList = userAdapter.getUserRoleDtoList(userRoles);

        //Assert
        actualList.forEach(actual -> {
            assertEquals(1L, actual.getRoleId());
            assertEquals("USER", actual.getUserName());
        });
    }

    @Test
    void itShouldNotGetUserRoleDto() {
        //Arrange
        UserRole userRole = new UserRole();
        userRole.setRoleId(1L);
        userRole.setRoleName("USER");

        //Act
        UserRoleDto actual = userAdapter.getUserRoleDto(userRole);

        //Assert
        assertNotEquals(2L, actual.getRoleId());
        assertNotEquals("ADMIN", actual.getUserName());
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
        List<UserRoleDto> actualList = userAdapter.getUserRoleDtoList(userRoles);

        //Assert
        actualList.forEach(actual -> {
            assertNotEquals(2L, actual.getRoleId());
            assertNotEquals("ADMIN", actual.getUserName());
        });
    }
}