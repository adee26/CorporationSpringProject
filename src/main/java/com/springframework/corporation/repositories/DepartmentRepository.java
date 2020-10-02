package com.springframework.corporation.repositories;

import com.springframework.corporation.entities.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findAll();
    Department findById(long id);
}
