package honeyshop.service.shop;

import honeyshop.adapter.blankhoney.BlankHoneyAdapter;
import honeyshop.adapter.inventorybeekeeper.InventoryBeekeeperAdapter;
import honeyshop.adapter.productbeekeeping.ProductBeekeeperAdapter;
import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.blankhoney.BlankHoney;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import honeyshop.model.productbeekeeping.ProductBeekeeper;
import honeyshop.repository.section.BlankHoneyRepos;
import honeyshop.repository.section.InventoryBeekeeperRepos;
import honeyshop.repository.section.ProductBeekeeperRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    private final BlankHoneyRepos blankHoneyRepos;
    private final InventoryBeekeeperRepos inventoryBeekeeperRepos;
    private final ProductBeekeeperRepos productBeekeeperRepos;
    private final BlankHoneyAdapter blankHoneyAdapter;
    private final InventoryBeekeeperAdapter inventoryBeekeeperAdapter;
    private final ProductBeekeeperAdapter productBeekeeperAdapter;

    @Autowired
    public ShopServiceImpl(BlankHoneyRepos blankHoneyRepos,
                           InventoryBeekeeperRepos inventoryBeekeeperRepos,
                           ProductBeekeeperRepos productBeekeeperRepos,
                           BlankHoneyAdapter blankHoneyAdapter,
                           InventoryBeekeeperAdapter inventoryBeekeeperAdapter,
                           ProductBeekeeperAdapter productBeekeeperAdapter) {
        this.blankHoneyRepos = blankHoneyRepos;
        this.inventoryBeekeeperRepos = inventoryBeekeeperRepos;
        this.productBeekeeperRepos = productBeekeeperRepos;
        this.blankHoneyAdapter = blankHoneyAdapter;
        this.inventoryBeekeeperAdapter = inventoryBeekeeperAdapter;
        this.productBeekeeperAdapter = productBeekeeperAdapter;
    }

    @Override
    public List<BlankHoneyDto> getAllBlanksHoney() {
        List<BlankHoney> blanksHoney = blankHoneyRepos.findAll();
        return blankHoneyAdapter.getBlankHoneyDtoList(blanksHoney);
    }

    @Override
    public List<InventoryBeekeeperDto> getAllInventoriesBeekeeper() {
        List<InventoryBeekeeper> inventoriesBeekeeper = inventoryBeekeeperRepos.findAll();
        return inventoryBeekeeperAdapter.getInventoryBeekeeperDtoList(inventoriesBeekeeper);
    }

    @Override
    public List<ProductBeekeeperDto> getAllProductsBeekeeper() {
        List<ProductBeekeeper> productsBeekeeper = productBeekeeperRepos.findAll();
        return productBeekeeperAdapter.getProductBeekeeperDtoList(productsBeekeeper);
    }

    @Override
    public BlankHoneyDto getBlankHoneyByName(String name) {
        Optional<BlankHoney> blankHoney = blankHoneyRepos.getBlankHoneyByName(name);
        if (blankHoney.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put("BlankHoneyNameNotFoundException", "Blank honey name not found");
            throw new HoneyShopException(failures, NO_CONTENT);
        }
        return blankHoneyAdapter.getBlankHoneyDto(blankHoney.get());
    }

    @Override
    public InventoryBeekeeperDto getInventoryBeekeeperByName(String name) {
        Optional<InventoryBeekeeper> inventoryBeekeeper = inventoryBeekeeperRepos.getInventoryBeekeeperByName(name);
        if (inventoryBeekeeper.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put("InventoryBeekeeperNameNotFoundException", "Inventory beekeeper name not found");
            throw new HoneyShopException(failures, NO_CONTENT);
        }
        return inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper.get());
    }

    @Override
    public ProductBeekeeperDto getProductsBeekeeperByName(String name) {
        Optional<ProductBeekeeper> productBeekeeper = productBeekeeperRepos.getProductBeekeeperByName(name);
        if (productBeekeeper.isEmpty()) {
            Map<String, String> failures = new HashMap<>();
            failures.put("ProductBeekeeperNameNotFoundException", "Product beekeeper name not found");
            throw new HoneyShopException(failures, NO_CONTENT);
        }
        return productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper.get());
    }
}
