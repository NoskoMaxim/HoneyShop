package honeyshop.repository.role;

import honeyshop.model.user.role.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepos extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findUserRoleByName(String roleName);
}
