package forex.copytradingforex.temp;

import forex.copytradingforex.model.entity.PositionEntity;
import forex.copytradingforex.model.entity.enums.TradeEnum;
import forex.copytradingforex.repository.PositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Temp implements CommandLineRunner {
    private final PasswordEncoder encoder;
    private final PositionRepository positionRepository;

    public Temp(PasswordEncoder encoder, PositionRepository positionRepository) {
        this.encoder = encoder;
        this.positionRepository = positionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        PositionEntity positionTest = new PositionEntity();

        positionTest.setTrade(TradeEnum.BUY);
//                .setTrader(testUser)
//                .setOpenTime(LocalDateTime.now())
//                .setCloseTime(LocalDateTime.now())
//                .setOpenPrice(BigDecimal.ONE)
//                .setClosePrice(BigDecimal.TEN)
//                .setFinancialResult(BigDecimal.TEN)
//                .setYield(BigDecimal.ONE);

        positionTest = positionRepository.save(positionTest);


//        BigDecimal a = BigDecimal.valueOf(-1000);
//        System.out.println(a);
//
//        BigDecimal b = BigDecimal.valueOf(10000);
//        System.out.println(a.divide(b));
//
//
//        System.out.println(encoder.encode("12345"));
//       // System.out.println(encoder.encode("test"));
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
    }
}
