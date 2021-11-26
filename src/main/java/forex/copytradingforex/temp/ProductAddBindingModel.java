//package forex.copytradingforex.temp;
//
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.validation.constraints.FutureOrPresent;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
//import javax.validation.constraints.Size;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//public class ProductAddBindingModel {
//    private String name;
//
//    private String description;
//    private BigDecimal price;
//
//
//    private LocalDateTime neededBefore;
//    private CategoryNameEnum category;
//
//
//    public ProductAddBindingModel() {
//    }
//
//    @NotNull(message = "Name length must be between 3 and 20 characters")
//    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
//    public String getName() {
//        return name;
//    }
//
//    public ProductAddBindingModel setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    //
//    @NotNull(message = "Description min length must be minimum 5(inclusive) characters")
//    @Size(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
//    public String getDescription() {
//        return description;
//    }
//
//    public ProductAddBindingModel setDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    @NotNull(message ="Price must be a positive number" )
//    @Positive(message = "Price must be a positive number")
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public ProductAddBindingModel setPrice(BigDecimal price) {
//        this.price = price;
//        return this;
//    }
//
//    @NotNull(message = "can not be empty")
//    @FutureOrPresent(message = "Date and Time, that cannot be in the past")
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//    public LocalDateTime getNeededBefore() {
//        return neededBefore;
//    }
//
//    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
//        this.neededBefore = neededBefore;
//        return this;
//    }
//
//    @NotNull
//    public CategoryNameEnum getCategory() {
//        return category;
//    }
//
//    public ProductAddBindingModel setCategory(CategoryNameEnum category) {
//        this.category = category;
//        return this;
//    }
//}
