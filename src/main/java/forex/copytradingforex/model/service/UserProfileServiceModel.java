package forex.copytradingforex.model.service;

import java.math.BigDecimal;

public class UserProfileServiceModel {
    Long id;
    String username;
    String fullName;
    BigDecimal initialCapital;

    String imageUrl;

    String email;
    Integer age;
    Integer experience;
    BigDecimal currentCapital;

    BigDecimal totalYield;


    public String getFullName() {
        return fullName;
    }

    public UserProfileServiceModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserProfileServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserProfileServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getExperience() {
        return experience;
    }

    public UserProfileServiceModel setExperience(Integer experience) {
        this.experience = experience;
        return this;
    }

    public BigDecimal getCurrentCapital() {
        return currentCapital;
    }

    public UserProfileServiceModel setCurrentCapital(BigDecimal currentCapital) {
        this.currentCapital = currentCapital;
        return this;
    }

    public BigDecimal getTotalYield() {
        return totalYield;
    }

    public UserProfileServiceModel setTotalYield(BigDecimal totalYield) {
        this.totalYield = totalYield;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserProfileServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public BigDecimal getInitialCapital() {
        return initialCapital;
    }

    public UserProfileServiceModel setInitialCapital(BigDecimal initialCapital) {
        this.initialCapital = initialCapital;
        return this;
    }
}
