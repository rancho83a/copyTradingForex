package forex.copytradingforex.events.positionsListeners;


import forex.copytradingforex.events.PositionCreatedEvent;
import forex.copytradingforex.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PositionCopyExecutor {
    private final UserService userService;
    private Logger LOGGER = LoggerFactory.getLogger(PositionCopyExecutor.class);

    public PositionCopyExecutor(UserService userService) {
        this.userService = userService;
    }


    @EventListener(PositionCreatedEvent.class)
    public  void onPositionCreated(PositionCreatedEvent positionCreatedEvent){

        LOGGER.info("Trader {} has been trade new position with yield {}%. I`m going to copy this positions to all his investors.",
                positionCreatedEvent.getTraderUsername(), positionCreatedEvent.getYield());

        userService.copyPositionToInvestors(positionCreatedEvent.getTraderUsername(), positionCreatedEvent.getYield());
    }

}
