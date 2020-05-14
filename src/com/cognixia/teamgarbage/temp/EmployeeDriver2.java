package com.cognixia.teamgarbage.temp;

import com.cognixia.teamgarbage.main.Company;
import com.cognixia.teamgarbage.main.Department;

public class EmployeeDriver2 {

	public static void main(String[] args) {
		
		Company c1 = new Company("Dunder Mifflin");
		
		// Departments
		Department d1 = new Department("Sales");
		System.out.println(d1.toString()); // company is null

		
		// Adding to Sales
		Employee e1 = new Employee("Jim", "Halpert");
		Employee e2 = new Employee("Phyllis", "Vance");
		
		System.out.println(e1.toString()); // company and department are null
		System.out.println(e2.toString());
		
		
		c1.addDepartment(d1);
		System.out.println("\n" + d1.toString());
		
		d1.addEmployee(e1);
		d1.addEmployee(e2);
		System.out.println(d1.toString() + "\n");
		System.out.println(e1.toString());
		
		System.out.println("\n" + e1.getEmployeeEmail());
		
		
	}

}
