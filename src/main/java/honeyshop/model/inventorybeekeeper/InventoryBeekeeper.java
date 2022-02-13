package honeyshop.model.inventorybeekeeper;

import javax.persistence.*;

@Entity
@Table(name = "inventory_beekeeper", schema = "public")
public class InventoryBeekeeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @PrimaryKeyJoinColumn
    private Long inventoryBeekeeperId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "photo")
    private Byte[] photo;

    public InventoryBeekeeper() {
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
