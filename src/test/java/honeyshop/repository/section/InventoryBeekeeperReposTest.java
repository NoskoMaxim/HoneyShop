package honeyshop.repository.section;

import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class InventoryBeekeeperReposTest {

    @Autowired
    private InventoryBeekeeperRepos underTestRepos;

    @AfterEach
    void tearDown() {
        underTestRepos.deleteAll();
    }

    @Test
    void itShouldGetInventoryBeekeeperByName() {

        //Arrange
        String inventoryBeekeeperName = "Акациевый мёд";
        InventoryBeekeeper inventoryBeekeeper = new InventoryBeekeeper();
        inventoryBeekeeper.setName(inventoryBeekeeperName);
        underTestRepos.save(inventoryBeekeeper);

        //Act
        Optional<InventoryBeekeeper> expected = underTestRepos
                .getInventoryBeekeeperByName(inventoryBeekeeperName);

        //Assert
        assertThat(expected.get().getName()).isEqualTo(inventoryBeekeeperName);
    }

    @Test
    void itShouldNotInventoryBeekeeperByNameByName() {

        //Arrange
        String inventoryBeekeeperName = "Акациевый мёд";

        //Act
        Optional<InventoryBeekeeper> expected = underTestRepos
                .getInventoryBeekeeperByName(inventoryBeekeeperName);

        //Assert
        assertThat(expected.isEmpty()).isTrue();
    }
}