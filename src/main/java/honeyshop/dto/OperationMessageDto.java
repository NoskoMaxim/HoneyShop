package honeyshop.dto;

public class OperationMessageDto {
    private final String text;

    public OperationMessageDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
