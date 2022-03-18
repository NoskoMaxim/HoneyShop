package honeyshop.dto.inventorybeekeeper;

public class InventoryBeekeeperDto {
    private Long inventoryBeekeeperId;
    private String name;
    private String description;
    private Integer price;
    private String photoUrl;

    public InventoryBeekeeperDto() {
    }

    public InventoryBeekeeperDto(Long inventoryBeekeeperId,
                                 String name,
                                 String description,
                                 Integer price,
                                 String photoUrl) {
        this.inventoryBeekeeperId = inventoryBeekeeperId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photoUrl = photoUrl;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
