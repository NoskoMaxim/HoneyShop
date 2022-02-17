package honeyshop.dto.user;

public class RoleToUserFormDto {
    private String username;
    private String roleName;

    public RoleToUserFormDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
