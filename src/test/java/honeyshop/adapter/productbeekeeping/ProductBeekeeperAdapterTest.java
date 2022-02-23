package honeyshop.adapter.productbeekeeping;

import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.productbeekeeping.ProductBeekeeper;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductBeekeeperAdapterTest {

    ProductBeekeeperAdapter productBeekeeperAdapter;

    @BeforeEach
    void setUp() {
        productBeekeeperAdapter = new ProductBeekeeperAdapterImpl();
    }

    @Test
    void itShouldGetProductBeekeeper() {
        //Arrange
        ProductBeekeeperDto productBeekeeperDto = new ProductBeekeeperDto();
        productBeekeeperDto.setName("Testing start");
        productBeekeeperDto.setDescription("Testing success");
        productBeekeeperDto.setPrice(15);
        productBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeper expected = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetProductBeekeeper() {
        //Arrange
        ProductBeekeeperDto productBeekeeperDto = new ProductBeekeeperDto();
        productBeekeeperDto.setName("Testing start");
        productBeekeeperDto.setDescription("Testing success");
        productBeekeeperDto.setPrice(15);
        productBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeper expected = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldGetProductBeekeeperDto() {
        //Arrange
        ProductBeekeeper productBeekeeper = new ProductBeekeeper();
        productBeekeeper.setName("Testing start");
        productBeekeeper.setDescription("Testing success");
        productBeekeeper.setPrice(15);
        productBeekeeper.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeperDto expected = productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetProductBeekeeperDto() {
        //Arrange
        ProductBeekeeper productBeekeeper = new ProductBeekeeper();
        productBeekeeper.setName("Testing start");
        productBeekeeper.setDescription("Testing success");
        productBeekeeper.setPrice(15);
        productBeekeeper.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeperDto expected = productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }
}