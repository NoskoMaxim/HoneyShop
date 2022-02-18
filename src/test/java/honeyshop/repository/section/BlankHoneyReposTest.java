package honeyshop.repository.section;

import honeyshop.model.blankhoney.BlankHoney;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class BlankHoneyReposTest {

    @Autowired
    private BlankHoneyRepos underTestRepos;

    @AfterEach
    void tearDown() {
        underTestRepos.deleteAll();
    }

    @Test
    void itShouldGetBlankHoneyByName() {

        //Arrange
        String blankHoneyName = "Акациевый мёд";
        BlankHoney blankHoney = new BlankHoney();
        blankHoney.setName(blankHoneyName);
        underTestRepos.save(blankHoney);

        //Act
        Optional<BlankHoney> expected = underTestRepos
                .getBlankHoneyByName(blankHoneyName);

        //Assert
        assertThat(expected.get().getName()).isEqualTo(blankHoneyName);
    }

    @Test
    void itShouldNotFindUserRoleByName() {

        //Arrange
        String blankHoneyName = "Акациевый мёд";

        //Act
        Optional<BlankHoney> expected = underTestRepos
                .getBlankHoneyByName(blankHoneyName);

        //Assert
        assertThat(expected.isEmpty()).isTrue();
    }
}