package honeyshop.model.productbeekeeping;

import javax.persistence.*;

@Entity
@Table(name = "product_beekeeping", schema = "public")
public class ProductBeekeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @PrimaryKeyJoinColumn
    private Long productBeekeeperId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "photo")
    private Byte[] photo;

    public ProductBeekeeper() {
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
