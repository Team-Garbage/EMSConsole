package com.cognixia.teamgarbage.main;

public class Employee {

	private String firstName;
	private String lastName;
	private Company company;
	private Department department;
	private String companyName;
	private String departmentName;

	
	// Constructor (Overloaded):
	public Employee(String firstName, String lastName, Company company, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.department = department;
		this.companyName = company.getCompanyName();
		this.departmentName = department.getDepartmentName();
	}
	public Employee(String firstName, String lastName, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = null;
		this.department = department;
		this.companyName = null;
		this.departmentName = department.getDepartmentName();
	}
	public Employee(String firstName, String lastName, Company company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.department = null;
		this.companyName = company.getCompanyName();
		this.departmentName = null;
	}
	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = null;
		this.department = null;
		this.companyName = null;
		this.departmentName = null;
	}

	
	
	// Methods:
	public String getEmployeeEmail() {
		
		if (departmentName == null && companyName != null) {
			return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + 
					companyName.toLowerCase().replaceAll("\\s+", "") + ".com";
		}
		else if (departmentName != null && companyName != null) {
			return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" 
					+ departmentName.toLowerCase().replaceAll("\\s+", "") + 
					"." + companyName.toLowerCase().replaceAll("\\s+", "") + ".com";
		}
		else {
			return "This employee has no email.";
		}
	}
	
	
	// Getters/Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
		this.departmentName = department.getDepartmentName(); // sets department name as well
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
		this.companyName = company.getCompanyName(); // sets company name as well
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	// ToString:
	@Override
	public String toString() {
		
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", company=" + companyName
				+ ", department="+ departmentName + "]";
	}
	
	
	
}
