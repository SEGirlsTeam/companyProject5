package com.company.demo.service;

import com.company.demo.model.Project;
import com.company.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project findProjectById(long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public void deleteProject(long id) {
        projectRepository.delete(id);
    }
}
