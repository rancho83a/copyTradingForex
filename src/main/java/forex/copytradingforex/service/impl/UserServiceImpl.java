package forex.copytradingforex.service.impl;

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

import java.math.BigDecimal;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    public static final String IMAGE_URL="https://res.cloudinary.com/drapmo8cx/image/upload/v1638274500/static/experience1_epfhyi.svg";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final CopyTradingForexUserServiceImpl copyTradingForexUserService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, CopyTradingForexUserServiceImpl copyTradingForexUserService, ModelMapper modelMapper) {
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

        BigDecimal initialCapital=BigDecimal.ZERO;
        if(userRegistrationServiceModel.getInitialCapital()!=null){
            initialCapital=userRegistrationServiceModel.getInitialCapital();
        }

        UserEntity newUser = new UserEntity()
                .setUsername(userRegistrationServiceModel.getUsername())
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setFullName(userRegistrationServiceModel.getFullName())
                .setEmail(userRegistrationServiceModel.getEmail())
                .setAge(userRegistrationServiceModel.getAge())
                .setExperience(userRegistrationServiceModel.getExperience())
                .setInitialCapital(initialCapital)
                .setCurrentCapital(initialCapital)
                .setImageUrl(userRegistrationServiceModel.getImageUrl() != null ? userRegistrationServiceModel.getImageUrl() : IMAGE_URL);









        RoleEntity role = roleRepository.getById(userRegistrationServiceModel.getRoleId());
        newUser.setRoles(Set.of(role));

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
        UserProfileServiceModel userProfileServiceModel = modelMapper.map(userEntity, UserProfileServiceModel.class);

        return modelMapper.map(userProfileServiceModel, UserProfileViewModel.class);
    }

    @Override
    public void depositAmount(BigDecimal amount, String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with " + username + " was not found"));
        userEntity.setCurrentCapital(userEntity.getCurrentCapital().add(amount));
        userRepository.save(userEntity);
    }

    @Override
    public void withdrawAmount(BigDecimal amount, String username) {
        UserEntity userEntity = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("User with " + username + " was not found"));
      BigDecimal currentCapital = userEntity.getCurrentCapital();

      if(currentCapital.compareTo(amount) < 0){
          //TODO mush message - not enought funds
          return;
      }

        userEntity.setCurrentCapital(currentCapital.subtract(amount));
        userRepository.save(userEntity);
    }
}
