package forex.copytradingforex.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trading_rules")
public class TradingRuleEntity extends BaseEntity{
    private String entryPoint;
    private String exitPoint;
    private Integer takeProfit;
    private Integer stopLoss;

}
