package forex.copytradingforex.model.entity.enums;

public enum EconomicIndicatorEnum {
    CPI("Consumer Price Index"),
    GDP("Gross domestic product"),
    INTEREST_RATE("Interest Rate Decision"),
    NFP("Non-farm Payrolls"),
    NBRNS("Norges Bank regional network Survey");

    private String indicator;

    EconomicIndicatorEnum(String indicator) {
        this.indicator = indicator;
    }

    public String getIndicator() {
        return indicator;
    }
}
