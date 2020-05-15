package com.cognixia.teamgarbage.main;

public class Manager extends Employee {

    public Manager(String fName, String lName, int empType) {
        super(fName, lName, empType);
    }

    public void fireEmployee(Employee emp) {
        System.out.println("You're fired " + emp.getfName() + "!");
    }

    public void goodJob(Employee emp) {
        System.out.println("Good job " + emp.getfName() + "!");
    }

}