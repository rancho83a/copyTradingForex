package forex.copytradingforex.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(nullable = false)
    private Boolean approved;

    @Column(columnDefinition = "TEXT")
    private String textContent;
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @ManyToOne
    private PositionEntity position;

    @ManyToOne
    private UserEntity author;



    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public CommentEntity setPosition(PositionEntity position) {
        this.position = position;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public CommentEntity setAuthor(UserEntity trader) {
        this.author = trader;
        return this;
    }
}
