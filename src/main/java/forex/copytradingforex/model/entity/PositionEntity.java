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
    private TradeEnum trade; //BYU or SELL
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private BigDecimal openPrice;
    private BigDecimal closePrice;
    private BigDecimal result;
    private String videoUrl;

    @ManyToOne
    private UserEntity trader;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "picture_id", referencedColumnName = "id")
    private PictureEntity picture;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;





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
