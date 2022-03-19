package honeyshop.service.inventorybeekeeper;

import honeyshop.adapter.inventorybeekeeper.InventoryBeekeeperAdapter;
import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import honeyshop.repository.section.InventoryBeekeeperRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.GONE;

@Service
@Transactional
public class InventoryBeekeeperServiceImpl implements InventoryBeekeeperService {

    private final InventoryBeekeeperRepos inventoryBeekeeperRepos;
    private final InventoryBeekeeperAdapter inventoryBeekeeperAdapter;

    @Autowired
    public InventoryBeekeeperServiceImpl(InventoryBeekeeperRepos inventoryBeekeeperRepos, InventoryBeekeeperAdapter inventoryBeekeeperAdapter) {
        this.inventoryBeekeeperRepos = inventoryBeekeeperRepos;
        this.inventoryBeekeeperAdapter = inventoryBeekeeperAdapter;
    }

    @Override
    public void addInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        InventoryBeekeeper inventoryBeekeeper = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);
        try {
            inventoryBeekeeperRepos.save(inventoryBeekeeper);
        } catch (DataIntegrityViolationException psqlException) {
            Map<String, String> failures = new HashMap<>();
            failures.put("InventoryBeekeeperNameException", "Inventory beekeeper name already exists");
            throw new HoneyShopException(failures, BAD_REQUEST);
        }
    }

    @Override
    public void updateInventoryBeekeeper(InventoryBeekeeperDto inventoryBeekeeperDto) {
        InventoryBeekeeper inventoryBeekeeper = inventoryBeekeeperAdapter.getInventoryBeekeeper(inventoryBeekeeperDto);
        inventoryBeekeeperRepos.save(inventoryBeekeeper);
    }

    @Override
    public void deleteInventoryBeekeeper(Long inventoryBeekeeperId) {
        try {
            inventoryBeekeeperRepos.deleteById(inventoryBeekeeperId);
        } catch (EmptyResultDataAccessException psqlException) {
            Map<String, String> failures = new HashMap<>();
            failures.put("NotFoundInventoryBeekeeperException", "Inventory beekeeper does not exist");
            throw new HoneyShopException(failures, GONE);
        }
    }
}
