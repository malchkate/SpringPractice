package requestsApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@SpringBootApplication
public class RequestsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestsAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RequestsRepository repository) {
		return (args) -> {
			repository.save(new Request(1, 1,
					OffsetDateTime.of(2018,1,9, 0,0,0,0,
							ZoneOffset.ofHours(3)), "CreditCard"));
			repository.save(new Request(1, 3,
					OffsetDateTime.of(2018,3,4,0,0,0,0,
							ZoneOffset.ofHours(3)), "CurrencyExchange"));
			repository.save(new Request(2, 1,
					OffsetDateTime.of(2018,2,22, 0,0,0,0,
							ZoneOffset.ofHours(3)), "CreditCard"));
			repository.save(new Request(1, 2,
					OffsetDateTime.of(2017,6,17, 0,0,0,0,
							ZoneOffset.ofHours(3)), "CreditApplication"));
			repository.save(new Request(2, 4,
					OffsetDateTime.of(2017,4,4, 0,0,0,0,
							ZoneOffset.ofHours(3)), "MortgageApplication"));
			repository.save(new Request(3, 4,
					OffsetDateTime.of(2015,1,2, 0,0,0,0,
							ZoneOffset.ofHours(3)), "MortgageApplication"));

		};
	}
}
