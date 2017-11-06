package com.company.demo.service;

import com.company.demo.model.Department;
import com.company.demo.model.Employee;

import java.util.List;

public interface DepartmentService {
    void save(Department department);

    List<Department> findAllDepartments();

    Department findDepartmentById(long id);

    void deleteDepartment(long id);
}
