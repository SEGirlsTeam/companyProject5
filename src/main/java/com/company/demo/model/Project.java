package com.company.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Project {

    private Department department;

    private Set<Employee>employees;
    private  long id;

    private  String name;
    private  long number;
    private  String location;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ManyToOne
    @JoinColumn(name="department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    @ManyToMany
    @JoinTable(name = "projects_employees",joinColumns=@JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_Id"))
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

