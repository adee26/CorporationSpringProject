package com.springframework.corporation.services;

import com.springframework.corporation.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee findById(long id);
    List<Employee> findByLastName(String name);
    Employee saveEmployee(Employee employee);
    void deleteById(long id);
    List<Employee> findByDepartment(long id);
    Employee updateEmployee(long id, Employee employee) throws Exception;
}
