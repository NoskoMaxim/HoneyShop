package honeyshop.dto.productsbeekeeping;

public class ProductBeekeeperDto {
    private Long productBeekeeperId;
    private String name;
    private String description;
    private Integer price;
    private Byte[] photo;

    public ProductBeekeeperDto() {
    }

    public Long getProductBeekeeperId() {
        return productBeekeeperId;
    }

    public void setProductBeekeeperId(Long productBeekeeperId) {
        this.productBeekeeperId = productBeekeeperId;
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
