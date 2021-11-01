package forex.copytradingforex.model.entity;

import javax.persistence.Entity;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name="positions")
public class PositionEntity extends BaseEntity{



    private Instant created;
    private Instant modified;


    @PrePersist
    public void beforeCreate(){
        this.created=Instant.now();
    }

    @PostPersist
    public void onUpdated(){
        this.modified=Instant.now();
    }

}
