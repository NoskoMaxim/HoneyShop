package honeyshop.adapter.inventorybeekeeper;

import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;

import java.util.ArrayList;
import java.util.List;

public class InventoryBeekeeperAdapterImpl implements InventoryBeekeeperAdapter {
    @Override
    public InventoryBeekeeper getInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        InventoryBeekeeper inventoryBeekeeper = new InventoryBeekeeper();
        inventoryBeekeeper.setInventoryBeekeeperId(inventoryBeekeeperDto.getInventoryBeekeeperId());
        inventoryBeekeeper.setName(inventoryBeekeeperDto.getName());
        inventoryBeekeeper.setDescription(inventoryBeekeeperDto.getDescription());
        inventoryBeekeeper.setPrice(inventoryBeekeeperDto.getPrice());
        inventoryBeekeeper.setPhotoUrl(inventoryBeekeeperDto.getPhotoUrl());
        return inventoryBeekeeper;
    }

    @Override
    public List<InventoryBeekeeperDto> getInventoryBeekeeperDtoList(List<InventoryBeekeeper> inventoriesBeekeeper) {
        List<InventoryBeekeeperDto> inventoriesBeekeeperDto = new ArrayList<>();
        inventoriesBeekeeper.forEach(inventoryBeekeeper ->
                inventoriesBeekeeperDto
                        .add(getInventoryBeekeeperDto(inventoryBeekeeper)));
        return inventoriesBeekeeperDto;

    }

    @Override
    public InventoryBeekeeperDto getInventoryBeekeeperDto(InventoryBeekeeper inventoryBeekeeper) {
        InventoryBeekeeperDto inventoryBeekeeperDto = new InventoryBeekeeperDto();
        inventoryBeekeeperDto.setInventoryBeekeeperId(inventoryBeekeeper
                .getInventoryBeekeeperId());
        inventoryBeekeeperDto.setName(inventoryBeekeeper.getName());
        inventoryBeekeeperDto.setDescription(inventoryBeekeeper.getDescription());
        inventoryBeekeeperDto.setPrice(inventoryBeekeeper.getPrice());
        inventoryBeekeeperDto.setPhotoUrl(inventoryBeekeeper.getPhotoUrl());
        return inventoryBeekeeperDto;
    }
}
