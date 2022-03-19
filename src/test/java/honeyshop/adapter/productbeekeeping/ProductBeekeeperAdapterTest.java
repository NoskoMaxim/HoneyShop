package honeyshop.adapter.productbeekeeping;

import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.productbeekeeping.ProductBeekeeper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProductBeekeeperAdapterTest {

    ProductBeekeeperAdapter productBeekeeperAdapter;

    @BeforeEach
    void setUp() {
        productBeekeeperAdapter = new ProductBeekeeperAdapter();
    }

    @Test
    void itShouldGetProductBeekeeper() {
        //Arrange
        ProductBeekeeperDto productBeekeeperDto = new ProductBeekeeperDto();
        productBeekeeperDto.setProductBeekeeperId(1L);
        productBeekeeperDto.setName("Testing start");
        productBeekeeperDto.setDescription("Testing success");
        productBeekeeperDto.setPrice(15);
        productBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeper expected = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);

        //Assert
        assertEquals(expected.getProductBeekeeperId(), 1L);
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetProductBeekeeper() {
        //Arrange
        ProductBeekeeperDto productBeekeeperDto = new ProductBeekeeperDto();
        productBeekeeperDto.setProductBeekeeperId(1L);
        productBeekeeperDto.setName("Testing start");
        productBeekeeperDto.setDescription("Testing success");
        productBeekeeperDto.setPrice(15);
        productBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeper expected = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);

        //Assert
        assertNotEquals(expected.getProductBeekeeperId(), 2L);
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }

    @Test
    void itShouldGetProductBeekeeperDto() {
        //Arrange
        ProductBeekeeper productBeekeeper = new ProductBeekeeper();
        productBeekeeper.setProductBeekeeperId(1L);
        productBeekeeper.setName("Testing start");
        productBeekeeper.setDescription("Testing success");
        productBeekeeper.setPrice(15);
        productBeekeeper.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeperDto expected = productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper);

        //Assert
        assertEquals(expected.getProductBeekeeperId(), 1L);
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetProductBeekeeperDto() {
        //Arrange
        ProductBeekeeper productBeekeeper = new ProductBeekeeper();
        productBeekeeper.setProductBeekeeperId(1L);
        productBeekeeper.setName("Testing start");
        productBeekeeper.setDescription("Testing success");
        productBeekeeper.setPrice(15);
        productBeekeeper.setPhotoUrl("Same URL");

        //Act
        ProductBeekeeperDto expected = productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper);

        //Assert
        assertNotEquals(expected.getProductBeekeeperId(), 2L);
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }

    @Test
    void itShouldGetProductBeekeeperDtoList() {
        //Arrange
        List<ProductBeekeeper> productsBeekeeper = List.of(
                new ProductBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                ),
                new ProductBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                )
        );

        //Act
        List<ProductBeekeeperDto> expectedList = productBeekeeperAdapter.getProductBeekeeperDtoList(productsBeekeeper);

        //Assert
        expectedList.forEach(expected->{
            assertEquals(expected.getProductBeekeeperId(), 1L);
            assertEquals(expected.getName(), "Testing start");
            assertEquals(expected.getDescription(), "Testing success");
            assertEquals(expected.getPrice(), 15);
            assertEquals(expected.getPhotoUrl(), "Same URL");
        });
    }

    @Test
    void itShouldNotGetProductBeekeeperDtoList() {
        //Arrange
        List<ProductBeekeeper> productsBeekeeper = List.of(
                new ProductBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                ),
                new ProductBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                )
        );

        //Act
        List<ProductBeekeeperDto> expectedList = productBeekeeperAdapter.getProductBeekeeperDtoList(productsBeekeeper);

        //Assert
        expectedList.forEach(expected->{
            assertNotEquals(expected.getProductBeekeeperId(), 2L);
            assertNotEquals(expected.getName(), "Testing no start");
            assertNotEquals(expected.getDescription(), "Testing no success");
            assertNotEquals(expected.getPrice(), 16);
            assertNotEquals(expected.getPhotoUrl(), "Same no URL");
        });
    }
}