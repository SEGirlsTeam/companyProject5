package com.company.demo.service;

import com.company.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);

    List<Employee> findAllEmployees();

    Employee findEmployeeById(long id);

    void deleteEmployee(long id);
}
