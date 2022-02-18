package honeyshop.repository.role;

import honeyshop.model.user.role.UserRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        String roleName = "VISITOR";
        UserRole role = new UserRole();
        role.setName(roleName);
        underTestRepos.save(role);

        //Act
        Optional<UserRole> expected = underTestRepos
                .findUserRoleByName(roleName);

        //Assert
        assertThat(expected.get().getName()).isEqualTo(roleName);
    }

    @Test
    void itShouldNotFindUserRoleByName() {

        //Arrange
        String roleName = "VISITOR";

        //Act
        Optional<UserRole> expected = underTestRepos
                .findUserRoleByName(roleName);

        //Assert
        assertThat(expected.isEmpty()).isTrue();
    }
}