package com.springframework.corporation.services;

import com.springframework.corporation.entities.Employee;
import com.springframework.corporation.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
//        List<Employee> employeeList = employeeRepository.findAll();
//        employeeList.removeIf(Employee::isDeleted);
        return employeeRepository.findAllByIsDeletedFalse();
        //transformToDTO(List<Employee> employeeList)
        // return employeeDTO list;
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByLastName(String name) {
        return employeeRepository.findByLastName(name);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
       Employee employee = employeeRepository.findById(id);
       employee.setDeleted(true);
       employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByDepartment(long id) {
        List<Employee> employeeList = employeeRepository.findEmployeesByDepartmentId(id);
        employeeList.removeIf(Employee::isDeleted);
        return employeeList;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) throws Exception {
        Employee employeeFromDB = employeeRepository.findById(id);
        if(employee != null){
            employeeFromDB.setFirstName(employee.getFirstName());
            employeeFromDB.setLastName(employee.getLastName());
            employeeFromDB.setDeleted(employee.isDeleted());
            employeeFromDB.setEmail(employee.getEmail());
            employeeFromDB.setPhoneNumber(employee.getPhoneNumber());
            employeeFromDB.setAccount(employee.getAccount());
            return employeeRepository.save(employeeFromDB);
        }else {
            throw new Exception("Employee doesn't exist");
        }
    }


}
