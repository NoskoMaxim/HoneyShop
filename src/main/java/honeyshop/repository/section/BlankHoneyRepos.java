package honeyshop.repository.section;

import honeyshop.model.blankhoney.BlankHoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlankHoneyRepos extends JpaRepository<BlankHoney, Long> {
    Optional<BlankHoney> getBlankHoneyByName(String name);
}
