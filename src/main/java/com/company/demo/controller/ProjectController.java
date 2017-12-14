package com.company.demo.controller;
import com.company.demo.model.Employee;
import com.company.demo.model.Project;
import com.company.demo.service.EmployeeService;
import com.company.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/project/add")
    public  String renderAddProjecttPage(Model model){
        model.addAttribute("project",new Project());
        return "add-project";
    }

    @PostMapping("/project/add")
    public  String addProject(@ModelAttribute("project") Project project){
        projectService.save(project);
        return  "redirect:/project/list";
    }

    @RequestMapping(value = {"/project/list","/"},method = RequestMethod.GET)
    public  String listProjects(Model model){
        List<Project> projects=projectService.findAllProjects();
        model.addAttribute("projects",projects);

        return "project-list";
    }


    @RequestMapping(value = "/project/edit/{id}")
    public  String editProject(@PathVariable("id")long id, Model model){
        Project project=projectService.findProjectById(id);
        model.addAttribute("project",project);
        return "add-project";
    }

    @RequestMapping(value = "/project/delete/{id}")
    public  String deleteProject(@PathVariable("id")long id){

        projectService.deleteProject(id);
        return "redirect:/project/list";
    }

}
