package honeyshop.service.shop;

import honeyshop.model.blankhoney.BlankHoney;
import honeyshop.repository.section.BlankHoneyRepos;
import honeyshop.repository.section.InventoryBeekeeperRepos;
import honeyshop.repository.section.ProductBeekeeperRepos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    @Mock
    private BlankHoneyRepos underTestBlankHoneyRepos;
    @Mock
    private InventoryBeekeeperRepos underTestInventoryBeekeeperRepos;
    @Mock
    private ProductBeekeeperRepos underTestProductBeekeeperRepos;

    private ShopService underTestService;

    @BeforeEach
    void setUp() {
        underTestService = new ShopService(
                underTestBlankHoneyRepos,
                underTestInventoryBeekeeperRepos,
                underTestProductBeekeeperRepos);
    }

    @Test
    void itShouldGetAllBlanksHoney() {

        //Act
        underTestService.getAllBlanksHoney();

        //Assert
        verify(underTestBlankHoneyRepos).findAll();
    }

    @Test
    void itShouldGetAllInventoriesBeekeeper() {
        //Act
        underTestService.getAllInventoriesBeekeeper();

        //Assert
        verify(underTestInventoryBeekeeperRepos).findAll();
    }

    @Test
    void itShouldGetAllProductsBeekeeper() {
        //Act
        underTestService.getAllProductsBeekeeper();

        //Assert
        verify(underTestProductBeekeeperRepos).findAll();
    }

    /*
     @Test
     void getBlankHoneyByName() {

         //Arrange
         String blankHoneyName = "Акациевый мёд";
         BlankHoney blankHoney = new BlankHoney();
         blankHoney.setName(blankHoneyName);
         underTestBlankHoneyRepos.save(blankHoney);
         //Act
         underTestService.getBlankHoneyByName(blankHoney.getName());

         //Assert
         ArgumentCaptor<BlankHoney> blankHoneyArgumentCaptor =
                 ArgumentCaptor.forClass(BlankHoney.class);

         verify(underTestBlankHoneyRepos).getBlankHoneyByName(blankHoneyName);

         BlankHoney capturedBlankHoney = blankHoneyArgumentCaptor.capture();

         assertThat(capturedBlankHoney).isEqualTo(blankHoney);
     }
    */

    @Test
    @Disabled
    void getInventoryBeekeeperByName() {
    }

    @Test
    @Disabled
    void getProductsBeekeeperByName() {
    }
}