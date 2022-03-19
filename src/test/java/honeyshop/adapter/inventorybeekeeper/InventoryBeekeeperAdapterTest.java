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
        InventoryBeekeeper expected = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);

        //Assert
        assertEquals(expected.getInventoryBeekeeperId(), 1L);
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
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
        InventoryBeekeeper expected = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);

        //Assert
        assertNotEquals(expected.getInventoryBeekeeperId(), 2L);
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
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
        InventoryBeekeeperDto expected = inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper);

        //Assert
        assertEquals(expected.getInventoryBeekeeperId(), 1L);
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
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
        InventoryBeekeeperDto expected = inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper);

        //Assert
        assertNotEquals(expected.getInventoryBeekeeperId(), 2L);
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
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
        List<InventoryBeekeeperDto> expectedList = inventoryBeekeeperAdapter.getInventoryBeekeeperDtoList(inventoriesBeekeeper);

        //Assert
        expectedList.forEach(expected->{
            assertEquals(expected.getInventoryBeekeeperId(), 1L);
            assertEquals(expected.getName(), "Testing start");
            assertEquals(expected.getDescription(), "Testing success");
            assertEquals(expected.getPrice(), 15);
            assertEquals(expected.getPhotoUrl(), "Same URL");
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
        List<InventoryBeekeeperDto> expectedList = inventoryBeekeeperAdapter.getInventoryBeekeeperDtoList(inventoriesBeekeeper);

        //Assert
        expectedList.forEach(expected->{
            assertNotEquals(expected.getInventoryBeekeeperId(), 2L);
            assertNotEquals(expected.getName(), "Testing no start");
            assertNotEquals(expected.getDescription(), "Testing no success");
            assertNotEquals(expected.getPrice(), 16);
            assertNotEquals(expected.getPhotoUrl(), "Same no URL");
        });
    }
}