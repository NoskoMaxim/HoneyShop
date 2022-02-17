package honeyshop.repository.role;

import honeyshop.model.user.role.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findUserRoleByName(String roleName);
}
