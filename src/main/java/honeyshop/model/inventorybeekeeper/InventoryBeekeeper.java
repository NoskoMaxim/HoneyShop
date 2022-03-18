package honeyshop.model.inventorybeekeeper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "inventory_beekeeper", schema = "public")
public class InventoryBeekeeper {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @PrimaryKeyJoinColumn
    private Long inventoryBeekeeperId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "photo_url")
    private String photoUrl;

    public InventoryBeekeeper() {
    }

    public InventoryBeekeeper(Long inventoryBeekeeperId,
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
