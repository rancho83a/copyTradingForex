package forex.copytradingforex.model.view;

import forex.copytradingforex.model.entity.enums.EconomicIndicatorEnum;

public class EconomicIndicatorViewModel {
    private Long id;
    private String indicator;

    public Long getId() {
        return id;
    }

    public EconomicIndicatorViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIndicator() {
        return indicator;
    }

    public EconomicIndicatorViewModel setIndicator(String indicator) {
        this.indicator = indicator;
        return this;
    }
}
