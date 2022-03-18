package honeyshop.adapter.productbeekeeping;

import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.productbeekeeping.ProductBeekeeper;

import java.util.ArrayList;
import java.util.List;

public class ProductBeekeeperAdapterImpl implements ProductBeekeeperAdapter {
    @Override
    public ProductBeekeeper getProductBeekeeper(ProductBeekeeperDto productBeekeeperDto) {
        ProductBeekeeper productBeekeeper = new ProductBeekeeper();
        productBeekeeper.setProductBeekeeperId(productBeekeeperDto.getProductBeekeeperId());
        productBeekeeper.setName(productBeekeeperDto.getName());
        productBeekeeper.setDescription(productBeekeeperDto.getDescription());
        productBeekeeper.setPrice(productBeekeeperDto.getPrice());
        productBeekeeper.setPhotoUrl(productBeekeeperDto.getPhotoUrl());
        return productBeekeeper;
    }

    @Override
    public List<ProductBeekeeperDto> getProductBeekeeperDtoList(List<ProductBeekeeper> productsBeekeeper) {
        List<ProductBeekeeperDto> productsBeekeeperDto = new ArrayList<>();
        productsBeekeeper.forEach(productBeekeeper ->
                productsBeekeeperDto
                        .add(getProductBeekeeperDto(productBeekeeper)));
        return productsBeekeeperDto;
    }

    @Override
    public ProductBeekeeperDto getProductBeekeeperDto(ProductBeekeeper productBeekeeper) {
        ProductBeekeeperDto productBeekeeperDto = new ProductBeekeeperDto();
        productBeekeeperDto.setProductBeekeeperId(productBeekeeper.getProductBeekeeperId());
        productBeekeeperDto.setName(productBeekeeper.getName());
        productBeekeeperDto.setDescription(productBeekeeper.getDescription());
        productBeekeeperDto.setPrice(productBeekeeper.getPrice());
        productBeekeeperDto.setPhotoUrl(productBeekeeper.getPhotoUrl());
        return productBeekeeperDto;
    }
}
