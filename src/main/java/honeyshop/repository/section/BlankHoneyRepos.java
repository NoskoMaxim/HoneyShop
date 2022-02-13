package honeyshop.repository.section;

import honeyshop.model.blankhoney.BlankHoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlankHoneyRepos extends JpaRepository<BlankHoney, Long> {
}
