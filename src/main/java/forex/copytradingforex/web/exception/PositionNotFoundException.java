package forex.copytradingforex.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Position Not found")
public class PositionNotFoundException extends RuntimeException {
    private final Long positionId;

    public PositionNotFoundException(Long positionId) {
        super("Position with id " + positionId + " was not found");
        this.positionId = positionId;
    }

    public Long getPositionId() {
        return positionId;
    }
}
