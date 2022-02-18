package honeyshop.model.user.role;

import honeyshop.model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    @PrimaryKeyJoinColumn
    private Long roleId;

    @Column(name = "name", unique = true)
    private String name;

    public UserRole() {
    }

    public UserRole(String name) {
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
