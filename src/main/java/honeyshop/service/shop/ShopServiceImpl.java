package honeyshop.service.shop;

import honeyshop.adapter.blankhoney.*;
import honeyshop.adapter.inventorybeekeeper.*;
import honeyshop.adapter.productbeekeeping.*;
import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.blankhoney.BlankHoney;
import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import honeyshop.model.productbeekeeping.ProductBeekeeper;
import honeyshop.repository.section.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    private final BlankHoneyRepos blankHoneyRepos;
    private final InventoryBeekeeperRepos inventoryBeekeeperRepos;
    private final ProductBeekeeperRepos productBeekeeperRepos;
    private final BlankHoneyAdapter blankHoneyAdapter = new BlankHoneyAdapterImpl();
    private final InventoryBeekeeperAdapter inventoryBeekeeperAdapter = new InventoryBeekeeperAdapterImpl();
    private final ProductBeekeeperAdapter productBeekeeperAdapter = new ProductBeekeeperAdapterImpl();

    @Autowired
    public ShopServiceImpl(BlankHoneyRepos blankHoneyRepos,
                           InventoryBeekeeperRepos inventoryBeekeeperRepos,
                           ProductBeekeeperRepos productBeekeeperRepos) {
        this.blankHoneyRepos = blankHoneyRepos;
        this.inventoryBeekeeperRepos = inventoryBeekeeperRepos;
        this.productBeekeeperRepos = productBeekeeperRepos;
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
        if (blankHoney.isEmpty()){
            Map<String, String> failures = new HashMap<>();
            failures.put("BlankHoneyNameNotFoundException", "Blank honey name not found");
            throw new HoneyShopException(failures);
        }
        return blankHoneyAdapter.getBlankHoneyDto(blankHoney.get());
    }

    @Override
    public InventoryBeekeeperDto getInventoryBeekeeperByName(String name) {
        Optional<InventoryBeekeeper> inventoryBeekeeper = inventoryBeekeeperRepos.getInventoryBeekeeperByName(name);
        if (inventoryBeekeeper.isEmpty()){
            Map<String, String> failures = new HashMap<>();
            failures.put("InventoryBeekeeperNameNotFoundException", "Inventory beekeeper name not found");
            throw new HoneyShopException(failures);
        }
        return inventoryBeekeeperAdapter.getInventoryBeekeeperDto(inventoryBeekeeper.get());
    }

    @Override
    public ProductBeekeeperDto getProductsBeekeeperByName(String name) {
        Optional<ProductBeekeeper> productBeekeeper = productBeekeeperRepos.getProductBeekeeperByName(name);
        if (productBeekeeper.isEmpty()){
            Map<String, String> failures = new HashMap<>();
            failures.put("ProductBeekeeperNameNotFoundException", "Product beekeeper name not found");
            throw new HoneyShopException(failures);
        }
        return productBeekeeperAdapter.getProductBeekeeperDto(productBeekeeper.get());
    }
}
