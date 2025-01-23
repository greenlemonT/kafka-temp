package kafka.paymentmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PaymentModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentModuleApplication.class, args);
    }

}
