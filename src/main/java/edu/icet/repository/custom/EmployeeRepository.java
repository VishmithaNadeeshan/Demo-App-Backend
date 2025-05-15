package edu.icet.repository.custom;
import edu.icet.entity.EmployeeEntity;
import edu.icet.util.DepartmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByName(String name);
    List<EmployeeEntity> findByEmail(String email);
    List<EmployeeEntity> findByDepartment(DepartmentType department);
}
