package honeyshop.adapter.inventorybeekeeper;

import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class InventoryBeekeeperAdapterTest {

    InventoryBeekeeperAdapter inventoryBeekeeperAdapter;

    @BeforeEach
    void setUp() {
        inventoryBeekeeperAdapter = new InventoryBeekeeperAdapterImpl();
    }

    @Test
    void itShouldGetInventoryBeekeeper() {
        //Arrange
        InventoryBeekeeperDto inventoryBeekeeperDto = new InventoryBeekeeperDto();
        inventoryBeekeeperDto.setName("Testing start");
        inventoryBeekeeperDto.setDescription("Testing success");
        inventoryBeekeeperDto.setPrice(15);
        inventoryBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeper expected = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetInventoryBeekeeper() {
        //Arrange
        InventoryBeekeeperDto inventoryBeekeeperDto = new InventoryBeekeeperDto();
        inventoryBeekeeperDto.setName("Testing start");
        inventoryBeekeeperDto.setDescription("Testing success");
        inventoryBeekeeperDto.setPrice(15);
        inventoryBeekeeperDto.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeper expected = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);

        //Assert
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }

    @Test
    void itShouldGetInventoryBeekeeperDto() {
        //Arrange
        InventoryBeekeeper inventoryBeekeeper = new InventoryBeekeeper();
        inventoryBeekeeper.setName("Testing start");
        inventoryBeekeeper.setDescription("Testing success");
        inventoryBeekeeper.setPrice(15);
        inventoryBeekeeper.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeperDto expected = inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper);

        //Assert
        assertEquals(expected.getName(), "Testing start");
        assertEquals(expected.getDescription(), "Testing success");
        assertEquals(expected.getPrice(), 15);
        assertEquals(expected.getPhotoUrl(), "Same URL");
    }

    @Test
    void itShouldNotGetInventoryBeekeeperDto() {
        //Arrange
        InventoryBeekeeper inventoryBeekeeper = new InventoryBeekeeper();
        inventoryBeekeeper.setName("Testing start");
        inventoryBeekeeper.setDescription("Testing success");
        inventoryBeekeeper.setPrice(15);
        inventoryBeekeeper.setPhotoUrl("Same URL");

        //Act
        InventoryBeekeeperDto expected = inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper);

        //Assert
        assertNotEquals(expected.getName(), "Testing no start");
        assertNotEquals(expected.getDescription(), "Testing no success");
        assertNotEquals(expected.getPrice(), 16);
        assertNotEquals(expected.getPhotoUrl(), "Same no URL");
    }
}