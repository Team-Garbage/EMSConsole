package com.cognixia.teamgarbage.main;

import java.util.ArrayList;
import java.util.List;

public class Department {

	// Attributes
	private String departmentName;
	private List<Employee> employees = new ArrayList<Employee>();
	private Company company;
	private String companyName;


	// Constructor (Overloaded)
	public Department(String departmentName, Company company) {
		this.departmentName = departmentName;
		this.company = company;
		this.companyName = company.getCompanyName();
	}
	public Department(String departmentName) {
		this.departmentName = departmentName;
		this.company = null;
		this.companyName = null;
	}

	
	// Method: adding employees to department
	public void addEmployee(Employee employee) {
		employee.setCompanyName(companyName); // updates company/department info
		employee.setDepartmentName(departmentName); 
		employees.add(employee);
		
	}
	// Method: removing employees from Department
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}



	// Getters/Setters 
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public int getDepartmentSize() {
		return employees.size();
	}

	public void setCompany(Company company) {
		this.company = company;
		this.companyName = company.getCompanyName(); // updates company name as well
	}
	public Company getCompany() {
		return company;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public List<Employee> getEmployees(){
		return employees;
	}
	
	// ToString
	@Override
	public String toString() {
		
		// Getting names of all Employees in Department
		String employeeNames = "";
		for (int i = 0; i < employees.size(); i++) {
			if (i == employees.size() -1) {
				employeeNames += employees.get(i).getFirstName() + " " + employees.get(i).getLastName();
			}
			else {
				employeeNames += employees.get(i).getFirstName() + " " + employees.get(i).getLastName() + ", ";
			}
		}
		
		return "Department [departmentName=" + departmentName + ", company=" + companyName
		+ ", employees=" + employeeNames + "]";
	}
	
	
	
	
	
}
