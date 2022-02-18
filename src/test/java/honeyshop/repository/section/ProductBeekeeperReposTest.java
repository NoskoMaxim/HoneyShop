package honeyshop.repository.section;

import honeyshop.model.productbeekeeping.ProductBeekeeper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductBeekeeperReposTest {

    @Autowired
    private ProductBeekeeperRepos underTestRepo;

    @AfterEach
    void tearDown() {
        underTestRepo.deleteAll();
    }

    @Test
    void itShouldGetProductBeekeeperByName() {

        //Arrange
        String productBeekeeperName = "Акациевый мёд";
        ProductBeekeeper inventoryBeekeeper = new ProductBeekeeper();
        inventoryBeekeeper.setName(productBeekeeperName);
        underTestRepo.save(inventoryBeekeeper);

        //Act
        Optional<ProductBeekeeper> expected = underTestRepo
                .getProductBeekeeperByName(productBeekeeperName);

        //Assert
        assertThat(expected.get().getName()).isEqualTo(productBeekeeperName);
    }

    @Test
    void itShouldNotProductBeekeeperByNameByName() {

        //Arrange
        String productBeekeeperName = "Акациевый мёд";

        //Act
        Optional<ProductBeekeeper> expected = underTestRepo
                .getProductBeekeeperByName(productBeekeeperName);

        //Assert
        assertThat(expected.isEmpty()).isTrue();
    }
}