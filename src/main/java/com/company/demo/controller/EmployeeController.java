package com.company.demo.controller;

import com.company.demo.model.Employee;
import com.company.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/add")
    public  String renderAddEmployeePage(Model model){
        model.addAttribute("employee",new Employee());
            return "add-employee";
    }

    @PostMapping("/employee/add")
    public  String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return  "redirect:/employee/list";
    }

    @RequestMapping(value = {"/employee/list","/"},method = RequestMethod.GET)
    public  String listEmployees(Model model){
        List <Employee> employees=employeeService.findAllEmployees();
        model.addAttribute("employees",employees);

        return "employee-list";
    }


    @RequestMapping(value = "/employee/edit/{id}")
    public  String editEmployee(@PathVariable("id")long id, Model model){
        Employee employee=employeeService.findEmployeeById(id);
        model.addAttribute("employee",employee);
        return "add-employee";
    }

    @RequestMapping(value = "/employee/delete/{id}")
    public  String deleteEmployee(@PathVariable("id")long id){

        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }

    @GetMapping("/employee/{id}/content")
    public String showEmployeeContent(@PathVariable("id")long employeeId,Model model){
        model.addAttribute("employeeId",employeeId);
        return "employee-content";
    }

}
