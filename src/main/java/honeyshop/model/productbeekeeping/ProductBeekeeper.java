package honeyshop.model.productbeekeeping;

import org.postgresql.util.PGmoney;

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
    private PGmoney price;

    @Column(name = "photo_url")
    private String photoUrl;

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

    public PGmoney getPrice() {
        return price;
    }

    public void setPrice(PGmoney price) {
        this.price = price;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
