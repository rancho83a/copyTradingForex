package forex.copytradingforex.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    private String imageUrl;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Integer experience;

    @Column(name="capital", columnDefinition="Decimal(19,2) default '0.00'")
    private BigDecimal capital;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();

    @ManyToOne
    private UserEntity trader;

    @OneToMany(mappedBy = "trader",fetch = FetchType.EAGER)
    private List<UserEntity> investors;



    public UserEntity() {
    }

    public UserEntity getTrader() {
        return trader;
    }

    public UserEntity setTrader(UserEntity trader) {
        this.trader = trader;
        return this;
    }

    public List<UserEntity> getInvestors() {
        return investors;
    }

    public UserEntity setInvestors(List<UserEntity> investors) {
        this.investors = investors;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String nickName) {
        this.email = nickName;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getExperience() {
        return experience;
    }

    public UserEntity setExperience(Integer experience) {
        this.experience = experience;
        return this;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public UserEntity setCapital(BigDecimal capital) {
        this.capital = capital;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }




}
