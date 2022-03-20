package honeyshop.model.user.role;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @PrimaryKeyJoinColumn
    private Long roleId;

    @Column(name = "name", unique = true)
    private String roleName;

    public UserRole() {
    }

    public UserRole(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String name) {
        this.roleName = name;
    }
}
