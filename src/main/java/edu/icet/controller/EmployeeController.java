package edu.icet.controller;

import edu.icet.dto.Employee;
import edu.icet.service.custom.EmployeeService;
import edu.icet.util.DepartmentType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/employee")


public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<Map<String, String>> addEmployee(@Valid @RequestBody Employee employee){
        employeeService.register(employee);
        Map<String, String> response = new HashMap<>();
        response.put("message", "employee registered successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, String>> updateCustomer(@Valid @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        Map<String, String> response = new HashMap<>();
        response.put("message","employee updated successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Employee> getData() {
        return employeeService.getAll();
    }

    @GetMapping("/search-by-id/{id}")
    public Employee searchEmployeeById(@PathVariable Integer id){
        return employeeService.searchEmployeeById(id);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Employee> searchEmployeeByName(@PathVariable String name){
        return employeeService.searchEmployeeByName(name);
    }

    @GetMapping("/search-by-email/{email}")
    public List<Employee> searchEmployeeByEmail(@PathVariable String email){
        return employeeService.searchEmployeeByEmail(email);
    }

    @GetMapping("/search-by-department/{department}")
    public List<Employee> searchEmployeeByDepartment(@PathVariable DepartmentType department){
        return employeeService.searchEmployeeByDepartment(department);
    }

}
