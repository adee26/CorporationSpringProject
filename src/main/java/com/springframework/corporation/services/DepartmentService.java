package com.springframework.corporation.services;

import com.springframework.corporation.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    Department findDepartmentById(long id);
    void deleteDepartmentById(long id);
}
