package feignClient;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class FeignClientApplication {

    public static void main(String[] args) {
        EmployeeClient employeeClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(EmployeeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(EmployeeClient.class, "http://localhost:8080/employees");
        List<Employee> employees = employeeClient.findAll().stream()
                .map(EmployeeResourse::getEmployee)
                .collect(Collectors.toList());
        if (employees != null) {
            for (Employee e : employees) {
                System.out.println(e.toString());
            }
        }
        Employee employee = employeeClient.findByEmpNo("4").getEmployee();
        if (employee != null){
            System.out.println(employee.toString());
        }
    }
}
