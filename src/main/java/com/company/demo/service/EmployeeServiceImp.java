package com.company.demo.service;

import com.company.demo.model.Employee;
import com.company.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EmployeeServiceImp implements  EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return  employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(long id) {
    return  employeeRepository.findOne(id);

    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.delete(id);
    }

}
