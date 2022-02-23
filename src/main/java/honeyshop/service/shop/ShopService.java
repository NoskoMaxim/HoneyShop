package honeyshop.service.shop;

import honeyshop.dto.blankhoney.BlankHoneyDto;
import honeyshop.dto.inventorybeekeeper.InventoryBeekeeperDto;
import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;

import java.util.List;

public interface ShopService {
    List<BlankHoneyDto> getAllBlanksHoney();

    List<InventoryBeekeeperDto> getAllInventoriesBeekeeper();

    List<ProductBeekeeperDto> getAllProductsBeekeeper();

    BlankHoneyDto getBlankHoneyByName(String name);

    InventoryBeekeeperDto getInventoryBeekeeperByName(String name);

    ProductBeekeeperDto getProductsBeekeeperByName(String name);
}
