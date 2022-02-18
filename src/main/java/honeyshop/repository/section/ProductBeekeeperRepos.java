package honeyshop.repository.section;

import honeyshop.model.productbeekeeping.ProductBeekeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductBeekeeperRepos extends JpaRepository<ProductBeekeeper, Long> {
    Optional<ProductBeekeeper> getProductBeekeeperByName(String name);
}
