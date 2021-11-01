package forex.copytradingforex.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String nickName;

    @Column(nullable = false)
    private String fullName;

    private String imageUrl;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Integer experience;

    @Column(nullable = false)
    private BigDecimal capital;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity() {
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

    public String getNickName() {
        return nickName;
    }

    public UserEntity setNickName(String nickName) {
        this.nickName = nickName;
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
