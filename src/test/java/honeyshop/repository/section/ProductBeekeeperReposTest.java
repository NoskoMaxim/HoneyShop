package honeyshop.repository.section;

import honeyshop.model.productbeekeeping.ProductBeekeeper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ProductBeekeeperReposTest {

    @Autowired
    private ProductBeekeeperRepos underTestRepos;

    @AfterEach
    void tearDown() {
        underTestRepos.deleteAll();
    }

    @Test
    void itShouldGetProductBeekeeperByName() {

        //Arrange
        String productBeekeeperName = "Акациевый мёд";
        ProductBeekeeper inventoryBeekeeper = new ProductBeekeeper();
        inventoryBeekeeper.setName(productBeekeeperName);
        underTestRepos.save(inventoryBeekeeper);

        //Act
        Optional<ProductBeekeeper> expected = underTestRepos
                .getProductBeekeeperByName(productBeekeeperName);

        //Assert
        assertThat(expected.get().getName()).isEqualTo(productBeekeeperName);
    }

    @Test
    void itShouldNotProductBeekeeperByNameByName() {

        //Arrange
        String productBeekeeperName = "Акациевый мёд";

        //Act
        Optional<ProductBeekeeper> expected = underTestRepos
                .getProductBeekeeperByName(productBeekeeperName);

        //Assert
        assertThat(expected.isEmpty()).isTrue();
    }
}