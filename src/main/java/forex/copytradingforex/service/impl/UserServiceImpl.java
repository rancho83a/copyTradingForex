package forex.copytradingforex.service.impl;

import forex.copytradingforex.model.entity.RoleEntity;
import forex.copytradingforex.model.entity.UserEntity;
import forex.copytradingforex.model.entity.enums.RoleEnum;
import forex.copytradingforex.model.service.UserRegistrationServiceModel;
import forex.copytradingforex.repository.RoleRepository;
import forex.copytradingforex.repository.UserRepository;
import forex.copytradingforex.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final CopyTradingForexUserServiceImpl copyTradingForexUserService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, CopyTradingForexUserServiceImpl copyTradingForexUserService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.copyTradingForexUserService = copyTradingForexUserService;

    }

    @Override
    public boolean isUserNameFree(String username) {
        return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {

        UserEntity newUser = new UserEntity()
                .setUsername(userRegistrationServiceModel.getUsername())
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setFullName(userRegistrationServiceModel.getFullName())
                .setEmail(userRegistrationServiceModel.getEmail())
                .setAge(userRegistrationServiceModel.getAge())
                .setExperience(userRegistrationServiceModel.getExperience());

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
}
