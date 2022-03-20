package honeyshop.service.inventorybeekeeper;

import honeyshop.adapter.inventorybeekeeper.InventoryBeekeeperAdapter;
import honeyshop.config.exception.honeyshopexception.SectionNameExistenceException;
import honeyshop.config.exception.honeyshopexception.SectionNotFoundException;
import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import honeyshop.repository.section.InventoryBeekeeperRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

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
            throw new SectionNameExistenceException(new HashMap<>() {{
                put("SectionNameExistenceException",
                        "Inventory beekeeper name: " + inventoryBeekeeper.getName() + " already exists");
            }});
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
            throw new SectionNotFoundException(new HashMap<>() {{
                put("SectionNotFoundException",
                        "Inventory beekeeper with ID: " + inventoryBeekeeperId + " does not exist");
            }}, GONE);
        }
    }
}
