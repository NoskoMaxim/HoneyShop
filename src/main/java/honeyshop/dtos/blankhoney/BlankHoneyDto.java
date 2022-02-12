package honeyshop.dtos.blankhoney;

public class BlankHoneyDto {
    private Long blankHoneyId;
    private String name;
    private String description;
    private Integer price;
    private Byte[] photo;

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
