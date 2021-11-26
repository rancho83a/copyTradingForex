package forex.copytradingforex.temp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Locale;

//@Component
public class Temp implements CommandLineRunner {
    private final PasswordEncoder encoder;

    public Temp(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(encoder.encode("12345"));
       // System.out.println(encoder.encode("test"));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }
}
