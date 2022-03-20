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
        ProductBeekeeper actual = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);

        //Assert
        assertEquals(1L, actual.getProductBeekeeperId());
        assertEquals("Testing start", actual.getName());
        assertEquals("Testing success", actual.getDescription());
        assertEquals(15, actual.getPrice());
        assertEquals("Same URL", actual.getPhotoUrl());
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
        ProductBeekeeper actual = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);

        //Assert
        assertNotEquals(2L, actual.getProductBeekeeperId());
        assertNotEquals("Testing no start", actual.getName());
        assertNotEquals("Testing no success", actual.getDescription());
        assertNotEquals(16, actual.getPrice());
        assertNotEquals("Same no URL", actual.getPhotoUrl());
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
        ProductBeekeeperDto actual = productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper);

        //Assert
        assertEquals(1L, actual.getProductBeekeeperId());
        assertEquals("Testing start", actual.getName());
        assertEquals("Testing success", actual.getDescription());
        assertEquals(15, actual.getPrice());
        assertEquals("Same URL", actual.getPhotoUrl());
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
        ProductBeekeeperDto actual = productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper);

        //Assert
        assertNotEquals(2L, actual.getProductBeekeeperId());
        assertNotEquals("Testing no start", actual.getName());
        assertNotEquals("Testing no success", actual.getDescription());
        assertNotEquals(16, actual.getPrice());
        assertNotEquals("Same no URL", actual.getPhotoUrl());
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
        List<ProductBeekeeperDto> actualList = productBeekeeperAdapter.getProductBeekeeperDtoList(productsBeekeeper);

        //Assert
        actualList.forEach(actual -> {
            assertEquals(1L, actual.getProductBeekeeperId());
            assertEquals("Testing start", actual.getName());
            assertEquals("Testing success", actual.getDescription());
            assertEquals(15, actual.getPrice());
            assertEquals("Same URL", actual.getPhotoUrl());
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
        List<ProductBeekeeperDto> actualList = productBeekeeperAdapter.getProductBeekeeperDtoList(productsBeekeeper);

        //Assert
        actualList.forEach(actual -> {
            assertNotEquals(2L, actual.getProductBeekeeperId());
            assertNotEquals("Testing no start", actual.getName());
            assertNotEquals("Testing no success", actual.getDescription());
            assertNotEquals(16, actual.getPrice());
            assertNotEquals("Same no URL", actual.getPhotoUrl());
        });
    }
}