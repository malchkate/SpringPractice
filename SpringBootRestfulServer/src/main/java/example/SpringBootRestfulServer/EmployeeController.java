package example.SpringBootRestfulServer;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    final private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @GetMapping(value="/employees")
    public Optional<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return Optional.ofNullable(employeeList);
    }

    @Transactional
    @GetMapping(value = "/employees/{empNo}")
    public Optional<Employee> getEmployee(@PathVariable String empNo) {
        Pageable pageRequest = PageRequest.of(0, 1, Sort.Direction.DESC, "empNo");
        List<Employee> employeesList = employeeRepository.findByEmpNo(empNo, pageRequest);

        return Optional.ofNullable(employeesList.get(0));
    }

    @Transactional
    @PutMapping(value = "/employees/{empNo}")
    public Optional<Employee> updateEmployee(@PathVariable String empNo,
                                             @RequestParam String position){
        Pageable pageRequest = PageRequest.of(0, 1, Sort.Direction.DESC, "empNo");
        List<Employee> employeesList = employeeRepository.findByEmpNo(empNo, pageRequest);

        Employee employee = employeesList.get(0);
        employeeRepository.delete(employee);

        employee.setPosition(position);
        employeeRepository.save(employee);

        return Optional.ofNullable(employee);
    }

    @Transactional
    @PostMapping(value = "/employees/{empNo}")
    public Optional<Employee> newEmployee(@PathVariable String empNo,
                                          @RequestParam String name,
                                          @RequestParam String position){
        Employee newEmployee = new Employee(empNo, name, position);
        employeeRepository.save(newEmployee);

        return Optional.ofNullable(newEmployee);
    }

    @Transactional
    @DeleteMapping(value = "/employees/{empNo}")
    public Optional<Employee> deleteEmployee(@PathVariable String empNo){
        Pageable pageRequest = PageRequest.of(0, 1, Sort.Direction.DESC, "empNo");
        List<Employee> employeesList = employeeRepository.findByEmpNo(empNo, pageRequest);
        employeeRepository.delete(employeesList.get(0));

        return Optional.ofNullable(employeesList.get(0));
    }

}
