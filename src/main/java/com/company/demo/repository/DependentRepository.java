package com.company.demo.repository;

import com.company.demo.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepository  extends JpaRepository<Dependent,Long>{
}
