package com.company.demo.service;


import com.company.demo.model.Dependent;
import com.company.demo.repository.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependentServiceImp implements DependentService {

    @Autowired
    private DependentRepository dependentRepository;
    @Override
    public void save(Dependent dependent) {
    dependentRepository.save(dependent);
    }

    @Override
    public List<Dependent> findAllDependents() {
        return dependentRepository.findAll();
    }

    @Override
    public Dependent findDependentById(long id) {
        return dependentRepository.findOne(id);
    }

    @Override
    public void deleteDependent(long id) {
        dependentRepository.delete(id);
    }
}
