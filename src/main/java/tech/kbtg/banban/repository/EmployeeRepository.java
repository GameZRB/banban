package tech.kbtg.banban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kbtg.banban.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
