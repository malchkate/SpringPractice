package example.SpringBootRestfulServer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRestfulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner fillRepo(EmployeeRepository repository){
		return (args) -> {
			repository.save(new Employee("1", "Ivanov",
					"trainee"));
			repository.save(new Employee("2", "Kotova",
					"boss"));
			repository.save(new Employee("3", "Sidorov",
					"secretary"));
			repository.save(new Employee("4", "Pavlov",
					"developer"));
			repository.save(new Employee("5", "Pushkin",
					"poet"));
			repository.save(new Employee("6", "Lidova",
					"office manager"));
			repository.save(new Employee("7", "Gredov",
					"scrum master"));
		};
	}
}
