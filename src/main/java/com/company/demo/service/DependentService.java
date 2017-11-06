package com.company.demo.service;

import com.company.demo.model.Dependent;
import com.company.demo.model.Employee;

import java.util.List;

public interface DependentService {
    void save(Dependent dependent);

    List<Dependent> findAllDependents();

    Dependent findDependentById(long id);

    void deleteDependent(long id);
}
