package forex.copytradingforex.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewCommentBindingModel {
    @NotBlank
    @Size(min=10)
    private String textContent;

    public String getTextContent() {
        return textContent;
    }

    public NewCommentBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }
}
