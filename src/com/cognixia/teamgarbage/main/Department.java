package com.cognixia.teamgarbage.main;

import java.util.ArrayList;
import java.util.List;

public class Department {

    // Attributes
    private int deptId;
    private String departmentName;
    private List<Employee> employees;
    private double budget;

    // Constructor
    public Department(String departmentName, double budget) {
        this.deptId = -1;
        this.departmentName = departmentName;
        this.budget = budget;
    }

    public Department(int deptId, String departmentName, double budget) {
        this.deptId = deptId;
        this.departmentName = departmentName;
        this.budget = budget;
    }

    // Method: adding employees to department
    public void addEmployee(Employee employee) {
        employees.add(employee);

    }

    // Method: removing employees from Department
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }


    // To String:
    @Override
    public String toString() {
        return "Department [departmentID = " + this.deptId + ", departmentName = " + departmentName + ", budget = " + budget + "]";
    }

    public String formattedData() {
        return deptId + "," + departmentName + "," + budget;
    }

}