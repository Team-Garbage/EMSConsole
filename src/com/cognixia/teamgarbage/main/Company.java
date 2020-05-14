package com.cognixia.teamgarbage.main;

import java.util.ArrayList;
import java.util.List;

public class Company {

	// Attributes
	private String companyName;
	private List<Department> departments = new ArrayList<Department>();
	
	// Constructor (Overloaded)
	public Company(String companyName) {
		this.companyName = companyName;
	}
	
	
	// Method: adding departments to company
	public void addDepartment(Department department){
		
		// checks if Department already exists with same name
		boolean b = false;
		for (Department d : departments) {
			if (d.getDepartmentName() == department.getDepartmentName()) {
				b = true;
				System.out.println("The "+ department.getDepartmentName() +" department already exists!");
			}
		}
		if (!b) {
			department.setCompanyName(companyName); // update company info
			departments.add(department);
		}
	}
	
	// Method: removing department from company
	public void removeDepartment(Department department) {
		
		// checks if Department to remove exists
		boolean b = false;
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getDepartmentName() == department.getDepartmentName()) {
				departments.remove(i);
				b = true;
			}
		}
		if (!b) {
			System.out.println(department.getDepartmentName() + " is not a valid department at "
					+ companyName + "!");
		}

	}
	
	
	// Getters and Setters:
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	// ToString:
	@Override
	public String toString() {
		
		// Getting names of all departments in company
		String departmentNames = "";
		for (int i = 0; i < departments.size(); i++) {
			if (i == departments.size() -1) {
				departmentNames += departments.get(i).getDepartmentName();;
			}
			else {
				departmentNames += departments.get(i).getDepartmentName() + ", ";
			}
		}
		return "Company [companyName=" + companyName + ", departments=" + departmentNames + "]";
	}	
	
}
