package forex.copytradingforex.model.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {

    private String title;
    private String url;
    @ManyToOne
    private UserEntity trader;

    @OneToOne(mappedBy = "picture")
    private PositionEntity position;
}
