package forex.copytradingforex.model.entity;


import forex.copytradingforex.model.entity.enums.CountryEnum;
import forex.copytradingforex.model.entity.enums.CurrencyPairEnum;
import forex.copytradingforex.model.entity.enums.EconomicIndicatorEnum;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="economic_indicators")
public class EconomicIndicatorEntity extends BaseEntity {
    private EconomicIndicatorEnum name;
    private CountryEnum country;
    private String description;

    @ManyToOne
    private CurrencyPairEntity currencyPair;

    @OneToOne
    private TradingRuleEntity rule;
}
