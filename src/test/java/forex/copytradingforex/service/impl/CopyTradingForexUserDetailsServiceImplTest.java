package forex.copytradingforex.service.impl;

import forex.copytradingforex.model.entity.RoleEntity;
import forex.copytradingforex.model.entity.UserEntity;
import forex.copytradingforex.model.entity.enums.RoleEnum;
import forex.copytradingforex.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CopyTradingForexUserDetailsServiceImplTest {

    private CopyTradingForexUserDetailsServiceImpl serviceToTest;
    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void init(){
        //ARRANGE
        serviceToTest = new CopyTradingForexUserDetailsServiceImpl(mockUserRepository);

        RoleEntity master = new RoleEntity().setRole(RoleEnum.MASTER);
        RoleEntity trader = new RoleEntity().setRole(RoleEnum.TRADER);
        RoleEntity investor = new RoleEntity().setRole(RoleEnum.INVESTOR);

        UserEntity testUser = new UserEntity();
        testUser.setUsername("master")
                .setEmail("master@copytradingforex.com")
                .setRoles(Set.of(master, trader, investor));
    }
    @Test
    void testUsernameNotFoundException(){
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                ()->serviceToTest.loadUserByUsername("invalid_username")
        );


    }


}