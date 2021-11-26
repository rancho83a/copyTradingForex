package forex.copytradingforex.model.entity;

import forex.copytradingforex.model.entity.enums.TradeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="positions")
public class PositionEntity extends BaseEntity{

    @ManyToOne
    private EconomicIndicatorEntity economicIndicator;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeEnum trade; //BYU or SELL

    private LocalDateTime openTime;
    private LocalDateTime closeTime;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,5)")
    private BigDecimal openPrice;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,5)")
    private BigDecimal closePrice;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal financialResult;

    private String videoUrl;

    @ManyToOne
    private UserEntity trader;

    @OneToOne(mappedBy = "position", cascade = CascadeType.ALL)
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private PictureEntity picture;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

    public EconomicIndicatorEntity getEconomicIndicator() {
        return economicIndicator;
    }

    public PositionEntity setEconomicIndicator(EconomicIndicatorEntity economicIndicator) {
        this.economicIndicator = economicIndicator;
        return this;
    }

    public TradeEnum getTrade() {
        return trade;
    }

    public PositionEntity setTrade(TradeEnum trade) {
        this.trade = trade;
        return this;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public PositionEntity setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
        return this;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public PositionEntity setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public PositionEntity setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public PositionEntity setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public BigDecimal getFinancialResult() {
        return financialResult;
    }

    public PositionEntity setFinancialResult(BigDecimal result) {
        this.financialResult = result;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public PositionEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserEntity getTrader() {
        return trader;
    }

    public PositionEntity setTrader(UserEntity trader) {
        this.trader = trader;
        return this;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public PositionEntity setPicture(PictureEntity picture) {
        this.picture = picture;
        return this;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public PositionEntity setComments(List<CommentEntity> comments) {
        this.comments = comments;
        return this;
    }

    //    private Instant created;
//    private Instant modified;
//
//
//    @PrePersist
//    public void beforeCreate(){
//        this.created=Instant.now();
//    }
//
//    @PostPersist
//    public void onUpdated(){
//        this.modified=Instant.now();
//    }

}
