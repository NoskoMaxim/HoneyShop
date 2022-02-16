package honeyshop.service.productbeekeeping;

import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.productbeekeeping.ProductBeekeeper;
import honeyshop.repository.section.ProductBeekeeperRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductBeekeeperService {

    private final ProductBeekeeperRepos productBeekeeperRepos;

    @Autowired
    public ProductBeekeeperService(ProductBeekeeperRepos productBeekeeperRepos) {
        this.productBeekeeperRepos = productBeekeeperRepos;
    }

    public void addProductBeekeeper(ProductBeekeeperDto productBeekeeperDto) {
        ProductBeekeeper productBeekeeper = new ProductBeekeeper();
        initProductBeekeeper(productBeekeeperDto, productBeekeeper);
        productBeekeeperRepos.save(productBeekeeper);
    }

    public void updateProductBeekeeper(ProductBeekeeperDto productBeekeeperDto) {
        ProductBeekeeper productBeekeeper = new ProductBeekeeper();
        productBeekeeper.setProductBeekeeperId(productBeekeeperDto.getProductBeekeeperId());
        initProductBeekeeper(productBeekeeperDto, productBeekeeper);
        productBeekeeperRepos.save(productBeekeeper);
    }

    public void deleteProductBeekeeper(Long productBeekeeperId) {
        productBeekeeperRepos.deleteById(productBeekeeperId);
    }

    private void initProductBeekeeper(ProductBeekeeperDto productBeekeeperDto, ProductBeekeeper productBeekeeper) {
        productBeekeeper.setName(productBeekeeperDto.getName());
        productBeekeeper.setDescription(productBeekeeperDto.getDescription());
        productBeekeeper.setPrice(productBeekeeperDto.getPrice());
        productBeekeeper.setPhotoUrl(productBeekeeperDto.getPhotoUrl());
    }
}
