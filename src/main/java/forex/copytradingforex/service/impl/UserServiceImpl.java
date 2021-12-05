package forex.copytradingforex.service.impl;

import forex.copytradingforex.config.TradingSettings;
import forex.copytradingforex.model.entity.RoleEntity;
import forex.copytradingforex.model.entity.UserEntity;
import forex.copytradingforex.model.service.UserRegistrationServiceModel;
import forex.copytradingforex.model.service.UserProfileServiceModel;
import forex.copytradingforex.model.view.UserProfileViewModel;
import forex.copytradingforex.repository.RoleRepository;
import forex.copytradingforex.repository.UserRepository;
import forex.copytradingforex.service.UserService;
import forex.copytradingforex.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    public static final String IMAGE_URL = "https://res.cloudinary.com/drapmo8cx/image/upload/v1638274500/static/experience1_epfhyi.svg";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final CopyTradingForexUserDetailsServiceImpl copyTradingForexUserService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository,
                           CopyTradingForexUserDetailsServiceImpl copyTradingForexUserService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.copyTradingForexUserService = copyTradingForexUserService;
        this.modelMapper = modelMapper;

    }

    @Override
    public boolean isUserNameFree(String username) {
        return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {

        BigDecimal currentCapital = BigDecimal.ZERO;
        if (userRegistrationServiceModel.getCurrentCapital() != null) {
            currentCapital = userRegistrationServiceModel.getCurrentCapital();
        }

        UserEntity newUser = new UserEntity()
                .setUsername(userRegistrationServiceModel.getUsername())
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setFullName(userRegistrationServiceModel.getFullName())
                .setEmail(userRegistrationServiceModel.getEmail())
                .setAge(userRegistrationServiceModel.getAge())
                .setExperience(userRegistrationServiceModel.getExperience())
                .setCurrentCapital(currentCapital)
                .setImageUrl(userRegistrationServiceModel.getImageUrl().isBlank() ? IMAGE_URL : userRegistrationServiceModel.getImageUrl())
                .setTotalDeposit(currentCapital)
                .setTotalWithdraw(BigDecimal.ZERO);


        RoleEntity role = roleRepository.getById(userRegistrationServiceModel.getRoleId());

        newUser.setRoles(List.of(role));

        newUser = userRepository.save(newUser);

        // this is spring representation of a user
        UserDetails principal = copyTradingForexUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public UserProfileViewModel findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with " + username + " was not found"));
        UserProfileServiceModel userProfileServiceModel = mapToUserProfileService(userEntity);

        return modelMapper.map(userProfileServiceModel, UserProfileViewModel.class);
    }

    private UserProfileServiceModel mapToUserProfileService(UserEntity userEntity) {
        UserProfileServiceModel userProfileServiceModel = modelMapper.map(userEntity, UserProfileServiceModel.class);
        userProfileServiceModel
                .setTotalYield(calculateTotalYield(userEntity.getCurrentCapital(), userEntity.getTotalWithdraw(), userEntity.getTotalDeposit())
                        .setScale(1, RoundingMode.FLOOR));

        if (userEntity.getTrader() != null) {
            userProfileServiceModel.setMyTrader(userEntity.getTrader().getFullName());
            userProfileServiceModel.setMyTraderId(userEntity.getTrader().getId());
        }
        return userProfileServiceModel;
    }

    private BigDecimal calculateTotalYield(BigDecimal currentCapital, BigDecimal totalWithdraw, BigDecimal totalDeposit) {
        if (totalDeposit.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return (currentCapital.add(totalWithdraw).subtract(totalDeposit))
                .multiply(BigDecimal.valueOf(100))
                .divide(totalDeposit, 6, RoundingMode.FLOOR);
    }

    @Override
    public void depositAmount(BigDecimal amount, String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with " + username + " was not found"));
        userEntity.setCurrentCapital(userEntity.getCurrentCapital().add(amount));
        userEntity.setTotalDeposit(userEntity.getTotalDeposit().add(amount));

        userRepository.save(userEntity);
    }

    @Override
    public void withdrawAmount(BigDecimal amount, String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with " + username + " was not found"));
        BigDecimal currentCapital = userEntity.getCurrentCapital();

        if (currentCapital.compareTo(amount) < 0) {
            //TODO push message - not enought funds
            return;
        }

        userEntity.setCurrentCapital(currentCapital.subtract(amount));
        userEntity.setTotalWithdraw(userEntity.getTotalWithdraw().add(amount));

        userRepository.save(userEntity);
    }

    @Override
    public boolean canTrade(String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with " + username + " was not found"));
        return userEntity.getCurrentCapital().compareTo(TradingSettings.requiredTradingCapital) > -1;
    }

    @Override
    public List<UserProfileViewModel> getAllTraders() {

        return userRepository.findAllTradersWithCapitalGreaterThanEqual(TradingSettings.requiredTradingCapital)
                .stream()
                .map(this::mapToUserProfileService)
                .map(t -> modelMapper.map(t, UserProfileViewModel.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void joinToCopy(String investorUsername, Long id) {
        UserEntity investor = this.userRepository.findByUsername(investorUsername)
                .orElseThrow(() -> new ObjectNotFoundException("Investor with " + investorUsername + " was not found"));

        UserEntity trader = this.userRepository.findByIdByEntityGraph(id)
                .orElseThrow(() -> new ObjectNotFoundException("Trader was not found"));

        investor.setTrader(trader);
        userRepository.save(investor);

        trader.addIvestor(investor);
        userRepository.save(trader);
    }

    @Override
    public boolean isJoinedToCopy(String username) {
        UserEntity investor = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with " + username + " was not found"));
        return investor.getTrader() != null;
    }

    @Transactional
    @Override
    public void revokeTrader(String investorUsername, Long traderId) {
        UserEntity investor = this.userRepository.findByUsername(investorUsername)
                .orElseThrow(() -> new ObjectNotFoundException("Investor with " + investorUsername + " was not found"));

        UserEntity trader = this.userRepository.findByIdByEntityGraph(traderId)
                .orElseThrow(() -> new ObjectNotFoundException("Trader was not found"));

        investor.setTrader(null);
        userRepository.save(investor);

        trader.removeInvestor(investor.getId());
        userRepository.save(trader);
    }


    @Override
    public void copyPositionToInvestors(String username, BigDecimal yield) {
        yield.add(BigDecimal.ZERO)
        UserEntity trader = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("Trader with username" + username + " was not found"));

        List<UserEntity> investors = trader.getInvestors();
        if (!investors.isEmpty()) {
            investors.stream()
                    .map(investor -> {


                        return investor;


                    });
        }
    }

}
