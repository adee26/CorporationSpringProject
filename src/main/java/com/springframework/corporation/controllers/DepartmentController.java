package com.springframework.corporation.controllers;

import com.springframework.corporation.entities.Department;
import com.springframework.corporation.entities.Employee;
import com.springframework.corporation.services.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/api/v1/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("api/v1/departments/{id}")
    public Department getDepartmentById(@PathVariable long id){
        return departmentService.findDepartmentById(id);
    }

    @PostMapping("api/v1/departments")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("api/v1/departments/{id}")
    public void deleteDepartmentById(@PathVariable long id){
       departmentService.deleteDepartmentById(id);
    }


}
