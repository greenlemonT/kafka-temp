package kafka.multiModuleService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MultiModuleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModuleServiceApplication.class, args);
	}

}
