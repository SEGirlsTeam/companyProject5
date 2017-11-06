package com.company.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    private Department department;
    private Set<Dependent> dependents;
    private  Set<Project> projects;


    private  long id;
   private long ssn;
   private String fName;
   private String mInit;
    private String lName;
   private String address;
   private double salary;
   private String sex;
   private  String birthDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmInit() {
        return mInit;
    }

    public void setmInit(String mInit) {
        this.mInit = mInit;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @ManyToOne
    @JoinColumn(name="department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    @OneToMany(mappedBy = "employee")
    public Set<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(Set<Dependent> dependents) {
        this.dependents = dependents;
    }
    @ManyToMany(mappedBy = "employees")
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
