package honeyshop.repository.user;

import honeyshop.model.user.User;
import honeyshop.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User,Long> {
    UserRole findUserByUsername(String username);
}
