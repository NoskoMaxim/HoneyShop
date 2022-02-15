package honeyshop.dto.productbeekeeping;

import org.postgresql.util.PGmoney;

public class ProductBeekeeperDto {
    private Long productBeekeeperId;
    private String name;
    private String description;
    private Integer price;
    private String photoUrl;

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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
