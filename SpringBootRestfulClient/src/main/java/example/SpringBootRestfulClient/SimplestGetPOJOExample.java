package example.SpringBootRestfulClient;

import example.SpringBootRestfulClient.model.Employee;
import org.springframework.web.client.RestTemplate;

public class SimplestGetPOJOExample {
    static final String URL_EMPLOYEES = "http://localhost:8080/employees";
    static final String URL_EMPLOYEES_JSON = "http://localhost:8080/employees.json";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        Employee[] list = restTemplate.getForObject(URL_EMPLOYEES, Employee[].class);

        if(list != null){
            for (Employee e: list) {
                System.out.println("Employee: " + e.getEmpNo() + "-" + e.getEmpName());
            }
        }
    }
}
