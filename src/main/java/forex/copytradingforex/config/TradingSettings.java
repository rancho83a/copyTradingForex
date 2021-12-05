package forex.copytradingforex.config;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TradingSettings {
    public final static BigDecimal requiredTradingCapital = new BigDecimal(1000);
    public final static BigDecimal requiredInvestorCapitalToJoin = new BigDecimal(2000);
    public final static BigDecimal StopLossEquityPercent = new BigDecimal(20);


}
