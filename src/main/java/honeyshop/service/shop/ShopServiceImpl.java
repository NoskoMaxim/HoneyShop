package honeyshop.service.shop;

import honeyshop.adapter.blankhoney.BlankHoneyAdapter;
import honeyshop.adapter.inventorybeekeeper.InventoryBeekeeperAdapter;
import honeyshop.adapter.productbeekeeping.ProductBeekeeperAdapter;
import honeyshop.config.exception.honeyshopexception.SectionNotFoundException;
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
        return blankHoneyRepos.getBlankHoneyByName(name)
                .map(blankHoneyAdapter::getBlankHoneyDto)
                .orElseThrow(() -> new SectionNotFoundException(
                        new HashMap<>() {{
                            put("SectionNotFoundException",
                                    "Blank honey name: " + name + " not found");
                        }}, NO_CONTENT)
                );
    }

    @Override
    public InventoryBeekeeperDto getInventoryBeekeeperByName(String name) {
        return inventoryBeekeeperRepos.getInventoryBeekeeperByName(name)
                .map(inventoryBeekeeperAdapter::getInventoryBeekeeperDto)
                .orElseThrow(() -> new SectionNotFoundException(
                        new HashMap<>() {{
                            put("SectionNotFoundException",
                                    "Inventory beekeeper name: " + name + " not found");
                        }}, NO_CONTENT)
                );
    }

    @Override
    public ProductBeekeeperDto getProductsBeekeeperByName(String name) {
        return productBeekeeperRepos.getProductBeekeeperByName(name)
                .map(productBeekeeperAdapter::getProductBeekeeperDto)
                .orElseThrow(() -> new SectionNotFoundException(
                        new HashMap<>() {{
                            put("SectionNotFoundException",
                                    "Product beekeeper name: " + name + " not found");
                        }}, NO_CONTENT)
                );
    }
}
