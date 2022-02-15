package honeyshop.dto.blankhoney;

import org.postgresql.util.PGmoney;

public class BlankHoneyDto {
    private Long blankHoneyId;
    private String name;
    private String description;
    private PGmoney price;
    private String photoUrl;

    public BlankHoneyDto() {
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
