package honeyshop.adapter.inventorybeekeeper;

import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InventoryBeekeeperAdapterTest {

    InventoryBeekeeperAdapter inventoryBeekeeperAdapter;

    @BeforeEach
    void setUp() {
        inventoryBeekeeperAdapter = new InventoryBeekeeperAdapter();
    }

    @Test
    void itShouldGetInventoryBeekeeper() {
        //Arrange
        InventoryBeekeeperDto inventoryBeekeeperDto = new InventoryBeekeeperDto();
        inventoryBeekeeperDto.setInventoryBeekeeperId(1L);
        inventoryBeekeeperDto.setName("Testing start");
        inventoryBeekeeperDto.setDescription("Testing success");
        inventoryBeekeeperDto.setPrice(15);
        inventoryBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeper actual = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);

        //Assert
        assertEquals(1L, actual.getInventoryBeekeeperId());
        assertEquals("Testing start", actual.getName());
        assertEquals("Testing success", actual.getDescription());
        assertEquals(15, actual.getPrice());
        assertEquals("Same URL", actual.getPhotoUrl());
    }

    @Test
    void itShouldNotGetInventoryBeekeeper() {
        //Arrange
        InventoryBeekeeperDto inventoryBeekeeperDto = new InventoryBeekeeperDto();
        inventoryBeekeeperDto.setInventoryBeekeeperId(1L);
        inventoryBeekeeperDto.setName("Testing start");
        inventoryBeekeeperDto.setDescription("Testing success");
        inventoryBeekeeperDto.setPrice(15);
        inventoryBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeper actual = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);

        //Assert
        assertNotEquals(2L, actual.getInventoryBeekeeperId());
        assertNotEquals("Testing no start", actual.getName());
        assertNotEquals("Testing no success", actual.getDescription());
        assertNotEquals(16, actual.getPrice());
        assertNotEquals("Same no URL", actual.getPhotoUrl());
    }

    @Test
    void itShouldGetInventoryBeekeeperDto() {
        //Arrange
        InventoryBeekeeper inventoryBeekeeper = new InventoryBeekeeper();
        inventoryBeekeeper.setInventoryBeekeeperId(1L);
        inventoryBeekeeper.setName("Testing start");
        inventoryBeekeeper.setDescription("Testing success");
        inventoryBeekeeper.setPrice(15);
        inventoryBeekeeper.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeperDto actual = inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper);

        //Assert
        assertEquals(1L, actual.getInventoryBeekeeperId());
        assertEquals("Testing start", actual.getName());
        assertEquals("Testing success", actual.getDescription());
        assertEquals(15, actual.getPrice());
        assertEquals("Same URL", actual.getPhotoUrl());
    }

    @Test
    void itShouldNotGetInventoryBeekeeperDto() {
        //Arrange
        InventoryBeekeeper inventoryBeekeeper = new InventoryBeekeeper();
        inventoryBeekeeper.setInventoryBeekeeperId(1L);
        inventoryBeekeeper.setName("Testing start");
        inventoryBeekeeper.setDescription("Testing success");
        inventoryBeekeeper.setPrice(15);
        inventoryBeekeeper.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeperDto actual = inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper);

        //Assert
        assertNotEquals(2L, actual.getInventoryBeekeeperId());
        assertNotEquals("Testing no start", actual.getName());
        assertNotEquals("Testing no success", actual.getDescription());
        assertNotEquals(16, actual.getPrice());
        assertNotEquals("Same no URL", actual.getPhotoUrl());
    }

    @Test
    void itShouldGetInventoryBeekeeperDtoList() {
        //Arrange
        List<InventoryBeekeeper> inventoriesBeekeeper = List.of(
                new InventoryBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                ),
                new InventoryBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                )
        );

        //Act
        List<InventoryBeekeeperDto> actualList = inventoryBeekeeperAdapter.getInventoryBeekeeperDtoList(inventoriesBeekeeper);

        //Assert
        actualList.forEach(actual -> {
            assertEquals(1L, actual.getInventoryBeekeeperId());
            assertEquals("Testing start", actual.getName());
            assertEquals("Testing success", actual.getDescription());
            assertEquals(15, actual.getPrice());
            assertEquals("Same URL", actual.getPhotoUrl());
        });
    }

    @Test
    void itShouldNotGetInventoryBeekeeperDtoList() {
        //Arrange
        List<InventoryBeekeeper> inventoriesBeekeeper = List.of(
                new InventoryBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                ),
                new InventoryBeekeeper(
                        1L,
                        "Testing start",
                        "Testing success",
                        15,
                        "Same URL"
                )
        );

        //Act
        List<InventoryBeekeeperDto> actualList = inventoryBeekeeperAdapter.getInventoryBeekeeperDtoList(inventoriesBeekeeper);

        //Assert
        actualList.forEach(actual -> {
            assertNotEquals(2L, actual.getInventoryBeekeeperId());
            assertNotEquals("Testing no start", actual.getName());
            assertNotEquals("Testing no success", actual.getDescription());
            assertNotEquals(16, actual.getPrice());
            assertNotEquals("Same no URL", actual.getPhotoUrl());
        });
    }
}