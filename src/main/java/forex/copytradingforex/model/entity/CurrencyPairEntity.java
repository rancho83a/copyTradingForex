package forex.copytradingforex.model.entity;


import forex.copytradingforex.model.entity.enums.CurrencyEnum;
import forex.copytradingforex.model.entity.enums.CurrencyPairEnum;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="currency_pairs")
public class CurrencyPairEntity extends BaseEntity{
    private CurrencyPairEnum name;
    private CurrencyEnum baseCurrency;
    private CurrencyEnum quoteCurrency;

    @OneToMany(mappedBy = "currencyPair")
    private List<EconomicIndicatorEntity> economicIndicators;
}
