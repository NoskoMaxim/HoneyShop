package honeyshop.repository.role;

import honeyshop.model.user.role.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class RoleReposTest {

    @Autowired
    private RoleRepos underTestRepos;

    @AfterEach
    void tearDown() {
        underTestRepos.deleteAll();
    }

    @Test
    void itShouldFindUserRoleByName() {

        //Arrange
        UserRole role = new UserRole();
        role.setRoleName("VISITOR");
        underTestRepos.save(role);

        //Act
        Optional<UserRole> actual = underTestRepos
                .findUserRoleByName("VISITOR");

        //Assert
        assertThat(actual.get().getRoleName()).isEqualTo("VISITOR");
    }

    @Test
    void itShouldNotFindUserRoleByName() {
        //Act
        Optional<UserRole> expected = underTestRepos
                .findUserRoleByName("VISITOR");

        //Assert
        assertThat(expected.isEmpty()).isTrue();
    }
}