package honeyshop.service.shop;

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
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShopService {

    private final BlankHoneyRepos blankHoneyRepos;
    private final InventoryBeekeeperRepos inventoryBeekeeperRepos;
    private final ProductBeekeeperRepos productBeekeeperRepos;

    @Autowired
    public ShopService(BlankHoneyRepos blankHoneyRepos,
                       InventoryBeekeeperRepos inventoryBeekeeperRepos,
                       ProductBeekeeperRepos productBeekeeperRepos) {
        this.blankHoneyRepos = blankHoneyRepos;
        this.inventoryBeekeeperRepos = inventoryBeekeeperRepos;
        this.productBeekeeperRepos = productBeekeeperRepos;
    }

    public List<BlankHoneyDto> getAllBlanksHoney() {
        List<BlankHoney> blanksHoney = blankHoneyRepos.findAll();
        return convertBlankHoneListToBlankHoneyDtoList(blanksHoney);
    }

    public List<InventoryBeekeeperDto> getAllInventoriesBeekeeper() {
        List<InventoryBeekeeper> inventoriesBeekeeper = inventoryBeekeeperRepos.findAll();
        return convertInventoryBeekeeperListToInventoryBeekeeperDtoList(inventoriesBeekeeper);
    }

    public List<ProductBeekeeperDto> getAllProductsBeekeeper() {
        List<ProductBeekeeper> productsBeekeeper = productBeekeeperRepos.findAll();
        return convertProductBeekeeperListToProductBeekeeperDtoList(productsBeekeeper);
    }

    public BlankHoneyDto getBlankHoneyByName(String name) {
        return convertBlankHoneToBlankHoneyDto(blankHoneyRepos
                .getBlankHoneyByName(name));
    }

    public InventoryBeekeeperDto getInventoryBeekeeperByName(String name) {
        return convertInventoryBeekeeperToInventoryBeekeeperDto(inventoryBeekeeperRepos
                .getInventoryBeekeeperByName(name));
    }

    public ProductBeekeeperDto getProductsBeekeeperByName(String name) {
        return convertProductBeekeeperToProductBeekeeperDto(productBeekeeperRepos
                .getProductBeekeeperByName(name));
    }

    private List<BlankHoneyDto> convertBlankHoneListToBlankHoneyDtoList(List<BlankHoney> blanksHoney) {
        List<BlankHoneyDto> blanksHoneyDto = new ArrayList<>();
        blanksHoney.forEach(blankHoney ->
                blanksHoneyDto.add(convertBlankHoneToBlankHoneyDto(blankHoney)));
        return blanksHoneyDto;
    }

    private List<InventoryBeekeeperDto> convertInventoryBeekeeperListToInventoryBeekeeperDtoList(List<InventoryBeekeeper> inventoriesBeekeeper) {
        List<InventoryBeekeeperDto> inventoriesBeekeeperDto = new ArrayList<>();
        inventoriesBeekeeper.forEach(inventoryBeekeeper ->
                inventoriesBeekeeperDto
                        .add(convertInventoryBeekeeperToInventoryBeekeeperDto(inventoryBeekeeper)));
        return inventoriesBeekeeperDto;

    }

    private List<ProductBeekeeperDto> convertProductBeekeeperListToProductBeekeeperDtoList(List<ProductBeekeeper> productsBeekeeper) {
        List<ProductBeekeeperDto> productsBeekeeperDto = new ArrayList<>();
        productsBeekeeper.forEach(productBeekeeper ->
                productsBeekeeperDto
                        .add(convertProductBeekeeperToProductBeekeeperDto(productBeekeeper)));
        return productsBeekeeperDto;
    }

    private BlankHoneyDto convertBlankHoneToBlankHoneyDto(BlankHoney blankHoney) {
        BlankHoneyDto blankHoneyDto = new BlankHoneyDto();
        blankHoneyDto.setBlankHoneyId(blankHoney.getBlankHoneyId());
        blankHoneyDto.setName(blankHoney.getName());
        blankHoneyDto.setDescription(blankHoney.getDescription());
        blankHoneyDto.setPrice(blankHoney.getPrice());
        blankHoneyDto.setPhotoUrl(blankHoney.getPhotoUrl());
        return blankHoneyDto;
    }

    private InventoryBeekeeperDto convertInventoryBeekeeperToInventoryBeekeeperDto(InventoryBeekeeper inventoryBeekeeper) {
        InventoryBeekeeperDto inventoryBeekeeperDto = new InventoryBeekeeperDto();
        inventoryBeekeeperDto.setInventoryBeekeeperId(inventoryBeekeeper
                .getInventoryBeekeeperId());
        inventoryBeekeeperDto.setName(inventoryBeekeeper.getName());
        inventoryBeekeeperDto.setDescription(inventoryBeekeeper.getDescription());
        inventoryBeekeeperDto.setPrice(inventoryBeekeeper.getPrice());
        inventoryBeekeeperDto.setPhotoUrl(inventoryBeekeeper.getPhotoUrl());
        return inventoryBeekeeperDto;
    }

    private ProductBeekeeperDto convertProductBeekeeperToProductBeekeeperDto(ProductBeekeeper productBeekeeper) {
        ProductBeekeeperDto productBeekeeperDto = new ProductBeekeeperDto();
        productBeekeeperDto.setProductBeekeeperId(productBeekeeper.getProductBeekeeperId());
        productBeekeeperDto.setName(productBeekeeper.getName());
        productBeekeeperDto.setDescription(productBeekeeper.getDescription());
        productBeekeeperDto.setPrice(productBeekeeper.getPrice());
        productBeekeeperDto.setPhotoUrl(productBeekeeper.getPhotoUrl());
        return productBeekeeperDto;
    }
}
