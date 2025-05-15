package edu.icet.service.custom;
import edu.icet.dto.Employee;
import edu.icet.util.DepartmentType;

import java.util.List;
public interface EmployeeService {
    void register(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> getAll();
    Employee searchEmployeeById(Integer id);
    List<Employee> searchEmployeeByName(String name);
    List<Employee> searchEmployeeByEmail(String email);
    List<Employee> searchEmployeeByDepartment(DepartmentType department);
}
