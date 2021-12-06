package forex.copytradingforex.service;

import forex.copytradingforex.model.entity.UserEntity;
import forex.copytradingforex.model.service.UserRegistrationServiceModel;
import forex.copytradingforex.model.view.UserProfileViewModel;

import java.math.BigDecimal;
import java.util.List;


public interface UserService {
    boolean isUserNameFree(String username);

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    UserProfileViewModel findByUsername(String username);

    void depositAmount(BigDecimal amount, String username);

    boolean withdrawAmount(BigDecimal amount, String username);

    boolean canTrade(String username);

    List<UserProfileViewModel> getAllTraders();

    void joinToCopy(String username, Long id);

    boolean isJoinedToCopy(String username);

    void revokeTrader(String investorUsername, Long traderId);

    void copyPositionToInvestors(String username, BigDecimal yield);

    BigDecimal[] remuneration(BigDecimal[] data);


    List<UserProfileViewModel> getInvestors(String username);
}
