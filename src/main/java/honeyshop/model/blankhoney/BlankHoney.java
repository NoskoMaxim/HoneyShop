package honeyshop.model.blankhoney;

import javax.persistence.*;

@Entity
@Table(name = "blank_honey", schema = "public")
public class BlankHoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @PrimaryKeyJoinColumn
    private Long blankHoneyId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "photo_url")
    private String photoUrl;

    public BlankHoney() {
    }

    public Long getBlankHoneyId() {
        return blankHoneyId;
    }

    public void setBlankHoneyId(Long blankHoneyId) {
        this.blankHoneyId = blankHoneyId;
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
