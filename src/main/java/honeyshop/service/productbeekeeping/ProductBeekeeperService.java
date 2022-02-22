package honeyshop.service.productbeekeeping;

import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;

public interface ProductBeekeeperService {
    void addProductBeekeeper(ProductBeekeeperDto productBeekeeperDto);
    void updateProductBeekeeper(ProductBeekeeperDto productBeekeeperDto);
    void deleteProductBeekeeper(Long productBeekeeperId);
}
