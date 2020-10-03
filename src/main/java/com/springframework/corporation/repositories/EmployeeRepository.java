package com.springframework.corporation.repositories;

import com.springframework.corporation.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByIsDeletedFalse();
   // List<Employee> findAllByDeletedFalse();
    Employee findById(long id);
    List<Employee> findByLastName(String name);
    List<Employee> findEmployeesByDepartmentId(long id);

}
