package com.company.demo.service;

import com.company.demo.model.Department;
import com.company.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements  DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public void save(Department department) {
    departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public void deleteDepartment(long id) {
        departmentRepository.delete(id);
    }
}
