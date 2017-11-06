package com.company.demo.controller;

import com.company.demo.model.Department;
import com.company.demo.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department/add")
    public  String renderAddDepartmentPage(Model model){
        model.addAttribute("department",new Department());
        return "add-department";
    }

    @PostMapping("/department/add")
    public  String addDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        return  "redirect:/department/list";
    }

    @RequestMapping(value = {"/department/list","/"},method = RequestMethod.GET)
    public  String listDepartments(Model model){
        List<Department> departments=departmentService.findAllDepartments();
        model.addAttribute("departments",departments);

        return "department-list";
    }


    @RequestMapping(value = "/department/edit/{id}")
    public  String editDepartment(@PathVariable("id")long id, Model model){
        Department department=departmentService.findDepartmentById(id);
        model.addAttribute("department",department);
        return "add-department";
    }

    @RequestMapping(value = "/department/delete/{id}")
    public  String deleteDepartment(@PathVariable("id")long id){

        departmentService.deleteDepartment(id);
        return "redirect:/department/list";
    }

}
