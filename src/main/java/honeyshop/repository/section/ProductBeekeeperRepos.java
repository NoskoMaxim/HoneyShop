package honeyshop.repository.section;

import honeyshop.model.productbeekeeping.ProductBeekeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBeekeeperRepos extends JpaRepository<ProductBeekeeper, Long> {
    ProductBeekeeper getProductBeekeeperByName(String name);
}
