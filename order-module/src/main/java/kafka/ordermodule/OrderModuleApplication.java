package kafka.ordermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class OrderModuleApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OrderModuleApplication.class, args);
        String kafkaBootstrapServers = context.getEnvironment().getProperty("spring.kafka.bootstrap-servers");
        System.out.println("Kafka Bootstrap Servers: " + kafkaBootstrapServers);
    }
}
