package forex.copytradingforex.service.aop;

import forex.copytradingforex.model.entity.UserEntity;
import forex.copytradingforex.service.UserService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class FundHistoryAspect {
    private final UserService userService;
    private BigDecimal capitalBeforeWithdraw =BigDecimal.valueOf(1000);

    public static final Logger LOGGER = LoggerFactory.getLogger(FundHistoryAspect.class);

    public FundHistoryAspect(UserService userService) {
        this.userService = userService;
    }

    @Pointcut("execution(* forex.copytradingforex.service.impl.UserServiceImpl.depositAmount(..))")
    public void truck() {
    }

    @After(value = "truck() && args(amount,username)", argNames = "amount,username")
    public void afterDepositAddHistoryRecord(BigDecimal amount, String username) {
        UserEntity user = userService.findUserByUsername(username);

        StringBuilder fundHistory = new StringBuilder(user.getFundHistory() == null ? "" : user.getFundHistory());

        StringBuilder newRecord = new StringBuilder()
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .append(" -- Deposit -- ").append(amount).append(" USD ")
                .append(" --  Current Capital: ").append(user.getCurrentCapital()).append(" USD")
                .append(System.lineSeparator());


        user.setFundHistory(fundHistory.insert(0,newRecord).append(System.lineSeparator()));

        userService.save(user);

        LOGGER.info(user.getFundHistory().toString());
    }

    @Pointcut("execution(* forex.copytradingforex.service.impl.UserServiceImpl.withdrawAmount(..))")
    public void truckWithdraw() {
    }


    @Before(value = "truckWithdraw() && args(amount,username)", argNames = "amount,username")
    public void beforeWithdrawAddHistoryRecord(BigDecimal amount, String username) {
        UserEntity user = userService.findUserByUsername(username);
        capitalBeforeWithdraw=user.getCurrentCapital();
    }


    @After(value = "truckWithdraw() && args(amount,username)", argNames = "amount,username")
    public void afterWithdrawAddHistoryRecord(BigDecimal amount, String username) {
        UserEntity user = userService.findUserByUsername(username);

        if(capitalBeforeWithdraw.compareTo(user.getCurrentCapital())==0){
            return;
        }

        StringBuilder fundHistory = new StringBuilder(user.getFundHistory() == null ? "" : user.getFundHistory());

        StringBuilder newRecord = new StringBuilder()
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .append(" -- Withdraw -- ").append(amount).append(" USD")
                .append(" --  Current Capital: ").append(user.getCurrentCapital()).append(" USD")
                .append(System.lineSeparator());

        user.setFundHistory(fundHistory.insert(0,newRecord));

        userService.save(user);

        LOGGER.info(user.getFundHistory().toString());
    }
}
