package forex.copytradingforex.service;

import forex.copytradingforex.model.service.UserRegistrationServiceModel;
import forex.copytradingforex.model.view.UserProfileViewModel;

import java.math.BigDecimal;


public interface UserService {
    boolean isUserNameFree(String username);

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    UserProfileViewModel findByUsername(String username);

    void depositAmount(BigDecimal amount, String username);

    void withdrawAmount(BigDecimal amount, String username);

    boolean canTrade(String username);
}
