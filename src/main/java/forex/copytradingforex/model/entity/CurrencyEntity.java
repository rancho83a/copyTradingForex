package forex.copytradingforex.model.entity;


import forex.copytradingforex.model.entity.enums.CountryEnum;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "currencies")
public class CurrencyEntity extends BaseEntity{
    private String name;
    private String code;
    private CountryEnum country;
}
