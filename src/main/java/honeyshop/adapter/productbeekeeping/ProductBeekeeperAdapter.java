package honeyshop.adapter.productbeekeeping;

import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.productbeekeeping.ProductBeekeeper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductBeekeeperAdapter {
    ModelMapper productBeekeeperMapper = new ModelMapper();

    public ProductBeekeeper getProductBeekeeper(ProductBeekeeperDto productBeekeeperDto) {
        return productBeekeeperMapper.map(productBeekeeperDto, ProductBeekeeper.class);
    }

    public ProductBeekeeperDto getProductBeekeeperDto(ProductBeekeeper productBeekeeper) {
        return productBeekeeperMapper.map(productBeekeeper, ProductBeekeeperDto.class);
    }

    public List<ProductBeekeeperDto> getProductBeekeeperDtoList(List<ProductBeekeeper> productsBeekeeper) {
        return productsBeekeeper.stream()
                .map(this::getProductBeekeeperDto)
                .collect(Collectors.toList());
    }
}
