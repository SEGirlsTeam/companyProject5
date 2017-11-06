package com.company.demo.controller;

import com.company.demo.model.Dependent;
import com.company.demo.model.Employee;
import com.company.demo.service.DependentService;
import com.company.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DependentController {
    @Autowired
    private DependentService dependentService;

    @GetMapping("/dependent/add")
    public  String renderAddDependentPage(Model model){
        model.addAttribute("dependent",new Dependent());
        return "add-dependent";
    }

    @PostMapping("/dependent/add")
    public  String addDependent(@ModelAttribute("dependent") Dependent dependent){
        dependentService.save(dependent);
        return  "redirect:/employee/list";
    }

    @RequestMapping(value = {"/dependent/list","/"},method = RequestMethod.GET)
    public  String listDependents(Model model){
        List<Dependent> dependents=dependentService.findAllDependents();
        model.addAttribute("dependents",dependents);

        return "dependent-list";
    }


    @RequestMapping(value = "/dependent/edit/{id}")
    public  String editDependent(@PathVariable("id")long id, Model model){
        Dependent dependent=dependentService.findDependentById(id);
        model.addAttribute("dependent",dependent);
        return "add-dependent";
    }

    @RequestMapping(value = "/dependent/delete/{id}")
    public  String deleteDependent(@PathVariable("id")long id){

        dependentService.deleteDependent(id);
        return "redirect:/dependent/list";
    }
}
