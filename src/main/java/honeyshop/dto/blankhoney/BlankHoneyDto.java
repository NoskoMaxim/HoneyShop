package honeyshop.dto.blankhoney;

public class BlankHoneyDto {
    private Long blankHoneyId;
    private String name;
    private String description;
    private Integer price;
    private String photoUrl;

    public BlankHoneyDto() {
    }

    public BlankHoneyDto(Long blankHoneyId,
                         String name,
                         String description,
                         Integer price,
                         String photoUrl) {
        this.blankHoneyId = blankHoneyId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photoUrl = photoUrl;
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
