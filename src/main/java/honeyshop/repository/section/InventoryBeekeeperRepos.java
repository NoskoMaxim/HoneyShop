package honeyshop.repository.section;

import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryBeekeeperRepos extends JpaRepository<InventoryBeekeeper, Long> {
    Optional<InventoryBeekeeper> getInventoryBeekeeperByName(String name);
}
