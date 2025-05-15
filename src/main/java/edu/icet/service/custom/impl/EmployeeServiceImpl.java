package edu.icet.service.custom.impl;
import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.custom.EmployeeRepository;
import edu.icet.service.custom.EmployeeService;
import edu.icet.util.DepartmentType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void register(Employee employee) {
        EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
        employeeRepository.save(employeeEntity);
    }

    @Override
    public void updateEmployee(Employee employee) {
        EmployeeEntity existing = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setUpdatedAt(LocalDateTime.now());

        employeeRepository.save(existing);
    }

    @Override
    public List<Employee> getAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        employeeEntityList.forEach(employeeEntity ->
                employeeList.add(modelMapper.map(employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public Employee searchEmployeeById(Integer id) {
        return modelMapper.map(employeeRepository.findById(id), Employee.class);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findByName(name);
        List<Employee> employeeList = new ArrayList<>();

        employeeEntityList.forEach(employeeEntity -> employeeList.add(modelMapper.map(employeeEntity, Employee.class)));
        return employeeList;
    }

    @Override
    public List<Employee> searchEmployeeByEmail(String email) {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findByEmail(email);
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeEntityList.forEach(employeeEntity -> employeeList.add(modelMapper.map(employeeEntity, Employee.class)));
        return employeeList;
    }

    @Override
    public List<Employee> searchEmployeeByDepartment(DepartmentType department) {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findByDepartment(department);
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeEntityList.forEach(employeeEntity -> employeeList.add(modelMapper.map(employeeEntity, Employee.class)));
        return employeeList;
    }
}
