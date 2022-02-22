package honeyshop.service.inventorybeekeeper;

import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import honeyshop.repository.section.InventoryBeekeeperRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class InventoryBeekeeperServiceImpl implements InventoryBeekeeperService {

    private final InventoryBeekeeperRepos inventoryBeekeeperRepos;

    @Autowired
    public InventoryBeekeeperServiceImpl(InventoryBeekeeperRepos inventoryBeekeeperRepos) {
        this.inventoryBeekeeperRepos = inventoryBeekeeperRepos;
    }

    @Override
    public void addInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        InventoryBeekeeper inventoryBeekeeper= new InventoryBeekeeper();
        initInventoryBeekeeper(inventoryBeekeeperDto, inventoryBeekeeper);
        try {
            inventoryBeekeeperRepos.save(inventoryBeekeeper);
        }catch (DataIntegrityViolationException psqlException){
            Map<String, String> failures = new HashMap<>();
            failures.put("InventoryBeekeeperNameException", "Inventory beekeeper name already exists");
            throw new HoneyShopException(failures);
        }
    }

    @Override
    public void updateInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        InventoryBeekeeper inventoryBeekeeper= new InventoryBeekeeper();
        inventoryBeekeeper.setInventoryBeekeeperId(inventoryBeekeeperDto.getInventoryBeekeeperId());
        initInventoryBeekeeper(inventoryBeekeeperDto, inventoryBeekeeper);
        inventoryBeekeeperRepos.save(inventoryBeekeeper);
    }

    @Override
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
