package forex.copytradingforex.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {


    private String title;

    //@Column(columnDefinition = "TEXT", nullable = false)
    @Lob
    private String url;

    @ManyToOne
    private UserEntity trader;

    @OneToOne
    private PositionEntity position;

    public String getTitle() {
        return title;
    }

    public PictureEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public UserEntity getTrader() {
        return trader;
    }

    public PictureEntity setTrader(UserEntity trader) {
        this.trader = trader;
        return this;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public PictureEntity setPosition(PositionEntity position) {
        this.position = position;
        return this;
    }
}
