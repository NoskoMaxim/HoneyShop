package honeyshop.adapter.productbeekeeping;

import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.productbeekeeping.ProductBeekeeper;

import java.util.List;

public interface ProductBeekeeperAdapter {
    ProductBeekeeper getProductBeekeeper(ProductBeekeeperDto productBeekeeperDto);

    List<ProductBeekeeperDto> getProductBeekeeperDtoList(List<ProductBeekeeper> productsBeekeeper);

    ProductBeekeeperDto getProductBeekeeperDto(ProductBeekeeper productBeekeeper);
}
