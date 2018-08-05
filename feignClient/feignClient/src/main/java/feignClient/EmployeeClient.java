package feignClient;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface EmployeeClient {

    @RequestLine("GET /{empNo}")
    EmployeeResourse findByEmpNo(@Param("empNo") String empNo);

    @RequestLine("GET")
    List<EmployeeResourse> findAll();
}
