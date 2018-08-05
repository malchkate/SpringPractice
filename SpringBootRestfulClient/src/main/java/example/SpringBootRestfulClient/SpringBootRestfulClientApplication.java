package example.SpringBootRestfulClient;

import example.SpringBootRestfulClient.model.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestfulClientApplication {


	public static void main(String[] args) {
		//SimplestGetExample.main(args);
		//GetWithHeadersExample.main(args);
		//SimplestGetPOJOExample.main(args);
		GetPOJOWithHeaderExample.main(args);
	}
}
