package honeyshop.repository.section;

import honeyshop.model.inventorybeekeeper.InventoryBeekeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryBeekeeperRepos extends JpaRepository<InventoryBeekeeper, Long> {
}
