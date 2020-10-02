package com.springframework.corporation.controllers;

import com.springframework.corporation.entities.Employee;
import com.springframework.corporation.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/v1/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/api/v1/employees/{id}")
    public Employee findEmployeeById(@PathVariable long id){
        return employeeService.findById(id);
    }

    @DeleteMapping("/api/v1/employees/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteById(id);
    }

    @PostMapping("/api/v1/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/api/v1/employees/departments/{id}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable("id") long id){
        return employeeService.findByDepartment(id);
    }

//    @PutMapping("/api/v1/employees/{id}")
//    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
//        employee = employeeService.findById(id);
//        return employeeService.saveEmployee(employee);
//    }
}





/** TO DO: Unique account for everyone. Is the user exists, do not create it. */