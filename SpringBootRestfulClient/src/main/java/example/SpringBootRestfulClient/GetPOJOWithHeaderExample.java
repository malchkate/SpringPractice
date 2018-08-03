package example.SpringBootRestfulClient;

import example.SpringBootRestfulClient.model.Employee;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GetPOJOWithHeaderExample {
    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");

        HttpEntity<Employee[]> entity = new HttpEntity<Employee[]>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Employee[]> response = restTemplate.exchange(URL_EMPLOYEES,
                HttpMethod.GET, entity, Employee[].class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        if  (statusCode == HttpStatus.OK){
            Employee[] list = response.getBody();

            if (list != null){
                for (Employee e: list) {
                    System.out.println("Employee: " + e.getEmpNo() + "-" + e.getEmpName());
                }
            }
        }
    }
}
