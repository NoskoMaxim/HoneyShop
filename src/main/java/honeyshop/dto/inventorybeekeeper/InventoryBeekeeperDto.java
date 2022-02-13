package honeyshop.dto.inventorybeekeeper;

public class InventoryBeekeeperDto {
    private Long inventoryBeekeeperId;
    private String name;
    private String description;
    private Integer price;
    private Byte[] photo;

    public InventoryBeekeeperDto() {
    }

    public Long getInventoryBeekeeperId() {
        return inventoryBeekeeperId;
    }

    public void setInventoryBeekeeperId(Long inventoryBeekeeperId) {
        this.inventoryBeekeeperId = inventoryBeekeeperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }
}
