package honeyshop.service.inventorybeekeeper;

import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;

public interface InventoryBeekeeperService {
    void addInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto);
    void updateInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto);
    void deleteInventoryBeekeeper(Long inventoryBeekeeperId);
}
