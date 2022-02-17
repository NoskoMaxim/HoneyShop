package honeyshop.dto.user;

public class UserRoleDto {
    private Long roleId;
    private String roleName;

    public UserRoleDto() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
