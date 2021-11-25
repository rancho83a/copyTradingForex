package forex.copytradingforex.model.entity;


import forex.copytradingforex.model.entity.enums.CurrencyEnum;
import forex.copytradingforex.model.entity.enums.CurrencyPairEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="currency_pairs")
public class CurrencyPairEntity extends BaseEntity{
    private CurrencyPairEnum name;

    @ManyToOne
    private CurrencyEntity baseCurrency;

    @ManyToOne
    private CurrencyEntity quoteCurrency;


}
