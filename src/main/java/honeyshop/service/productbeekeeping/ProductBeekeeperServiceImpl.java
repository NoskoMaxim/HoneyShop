package honeyshop.service.productbeekeeping;

import honeyshop.adapter.productbeekeeping.*;
import honeyshop.config.exception.honeyshopexception.HoneyShopException;
import honeyshop.dto.productbeekeeping.ProductBeekeeperDto;
import honeyshop.model.productbeekeeping.ProductBeekeeper;
import honeyshop.repository.section.ProductBeekeeperRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
@Transactional
public class ProductBeekeeperServiceImpl implements ProductBeekeeperService {

    private final ProductBeekeeperRepos productBeekeeperRepos;
    private final ProductBeekeeperAdapter productBeekeeperAdapter = new ProductBeekeeperAdapterImpl();

    @Autowired
    public ProductBeekeeperServiceImpl(ProductBeekeeperRepos productBeekeeperRepos) {
        this.productBeekeeperRepos = productBeekeeperRepos;
    }

    @Override
    public void addProductBeekeeper(ProductBeekeeperDto productBeekeeperDto) {
        ProductBeekeeper productBeekeeper = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);
        try {
            productBeekeeperRepos.save(productBeekeeper);
        } catch (DataIntegrityViolationException psqlException) {
            Map<String, String> failures = new HashMap<>();
            failures.put("ProductBeekeeperNameException", "Product beekeeper name already exists");
            throw new HoneyShopException(failures, BAD_REQUEST);
        }
    }

    @Override
    public void updateProductBeekeeper(ProductBeekeeperDto productBeekeeperDto) {
        ProductBeekeeper productBeekeeper = productBeekeeperAdapter.getProductBeekeeper(productBeekeeperDto);
        productBeekeeper.setProductBeekeeperId(productBeekeeperDto.getProductBeekeeperId());
        productBeekeeperRepos.save(productBeekeeper);
    }

    @Override
    public void deleteProductBeekeeper(Long productBeekeeperId) {
        try {
            productBeekeeperRepos.deleteById(productBeekeeperId);
        } catch (EmptyResultDataAccessException psqlException) {
            Map<String, String> failures = new HashMap<>();
            failures.put("NotFoundProductBeekeeperException", "Product beekeeper does not exist");
            throw new HoneyShopException(failures, GONE);
        }
    }
}
