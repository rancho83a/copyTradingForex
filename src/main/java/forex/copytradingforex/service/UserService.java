package forex.copytradingforex.service;

import forex.copytradingforex.model.service.UserRegistrationServiceModel;
import org.springframework.stereotype.Service;


public interface UserService {
    boolean isUserNameFree(String username);

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);
}
