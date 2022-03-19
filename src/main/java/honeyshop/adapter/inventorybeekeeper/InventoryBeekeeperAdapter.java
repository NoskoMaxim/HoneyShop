package honeyshop.adapter.inventorybeekeeper;

import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryBeekeeperAdapter {
    ModelMapper inventoryBeekeeperMapper = new ModelMapper();

    public InventoryBeekeeper getInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        return inventoryBeekeeperMapper.map(inventoryBeekeeperDto, InventoryBeekeeper.class);
    }

    public InventoryBeekeeperDto getInventoryBeekeeperDto(InventoryBeekeeper inventoryBeekeeper) {
        return inventoryBeekeeperMapper.map(inventoryBeekeeper, InventoryBeekeeperDto.class);
    }

    public List<InventoryBeekeeperDto> getInventoryBeekeeperDtoList(List<InventoryBeekeeper> inventoriesBeekeeper) {
        return inventoriesBeekeeper.stream()
                .map(this::getInventoryBeekeeperDto)
                .collect(Collectors.toList());
    }
}