package honeyshop.repository.user;

import honeyshop.model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserReposTest {

    @Autowired
    private UserRepos underTestRepos;

    @AfterEach
    void tearDown() {
        underTestRepos.deleteAll();
    }

    @Test
    void itShouldFindUserByUsername() {

        //Arrange
        String username = "Max";
        User user = new User();
        user.setUsername(username);
        underTestRepos.save(user);

        //Act
        Optional<User> expected = underTestRepos
                .findUserByUsername(username);

        //Assert
        assertThat(expected.get().getUsername()).isEqualTo(username);
    }

    @Test
    void itShouldNotFindUserByUsername() {

        //Arrange
        String username = "Max";

        //Act
        Optional<User> expected = underTestRepos
                .findUserByUsername(username);

        //Assert
        assertThat(expected.isEmpty()).isTrue();
    }
}