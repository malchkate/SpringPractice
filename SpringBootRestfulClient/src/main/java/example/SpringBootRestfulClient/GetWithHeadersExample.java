package example.SpringBootRestfulClient;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GetWithHeadersExample {
    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES,
                HttpMethod.GET, entity, String.class);

        String result = response.getBody();

        System.out.println(result);
    }
}
