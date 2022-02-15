package honeyshop.service.inventorybeekeeper;

import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import honeyshop.repository.section.InventoryBeekeeperRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryBeekeeperService {

    private final InventoryBeekeeperRepos inventoryBeekeeperRepos;

    @Autowired
    public InventoryBeekeeperService(InventoryBeekeeperRepos inventoryBeekeeperRepos) {
        this.inventoryBeekeeperRepos = inventoryBeekeeperRepos;
    }

    public void addInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        InventoryBeekeeper inventoryBeekeeper= new InventoryBeekeeper();
        initInventoryBeekeeper(inventoryBeekeeperDto, inventoryBeekeeper);
        inventoryBeekeeperRepos.save(inventoryBeekeeper);
    }

    public void updateInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        InventoryBeekeeper inventoryBeekeeper= new InventoryBeekeeper();
        inventoryBeekeeper.setInventoryBeekeeperId(inventoryBeekeeperDto.getInventoryBeekeeperId());
        initInventoryBeekeeper(inventoryBeekeeperDto, inventoryBeekeeper);
        inventoryBeekeeperRepos.save(inventoryBeekeeper);
    }

    public void deleteInventoryBeekeeper(Long inventoryBeekeeperId) {
        inventoryBeekeeperRepos.deleteById(inventoryBeekeeperId);
    }

    private void initInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto, InventoryBeekeeper inventoryBeekeeper) {
        inventoryBeekeeper.setName(inventoryBeekeeperDto.getName());
        inventoryBeekeeper.setDescription(inventoryBeekeeperDto.getDescription());
        inventoryBeekeeper.setPrice(inventoryBeekeeperDto.getPrice());
        inventoryBeekeeper.setPhotoUrl(inventoryBeekeeperDto.getPhotoUrl());
    }
}
