package com.company.demo.service;

import com.company.demo.model.Department;
import com.company.demo.model.Project;

import java.util.List;

public interface ProjectService {
    void save(Project project);

    List<Project> findAllProjects();

    Project findProjectById(long id);

    void deleteProject(long id);
}
