package requestsApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.GregorianCalendar;

@SpringBootApplication
public class RequestsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestsAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RequestsRepository repository) {
		return (args) -> {
			repository.save(new Request(1, 1, new GregorianCalendar(2018,1,9), "CreditCard"));
			repository.save(new Request(1, 3, new GregorianCalendar(2018,3,4), "CurrencyExchange"));
			repository.save(new Request(2, 1, new GregorianCalendar(2018,2,22), "CreditCard"));
			repository.save(new Request(1, 2, new GregorianCalendar(2017,6,17), "CreditApplication"));
			repository.save(new Request(2, 4, new GregorianCalendar(2017,4,4), "MortgageApplication"));
			repository.save(new Request(3, 4, new GregorianCalendar(2015,1,2), "MortgageApplication"));

		};
	}
}
