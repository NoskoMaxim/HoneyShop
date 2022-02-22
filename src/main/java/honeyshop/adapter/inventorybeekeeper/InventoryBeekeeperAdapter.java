package honeyshop.adapter.inventorybeekeeper;

import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;

import java.util.List;

public interface InventoryBeekeeperAdapter {

    InventoryBeekeeper getInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto);

    List<InventoryBeekeeperDto> getInventoryBeekeeperDtoList(List<InventoryBeekeeper> inventoriesBeekeeper);

    InventoryBeekeeperDto getInventoryBeekeeperDto(InventoryBeekeeper inventoryBeekeeper);
}
