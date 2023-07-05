package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeServices {
    List<Employee> getAllEmployee();
    void save(Employee employee);
    Employee getById(Long id);
    void deleteViaId(Long id);
}
