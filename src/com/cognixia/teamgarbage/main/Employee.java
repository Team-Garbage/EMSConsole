package com.cognixia.teamgarbage.main;

public abstract class Employee {
	private String fName;
	private String lName;
	private int empId;
	private MonthShift ms;
	private Employee manager;
	private int empType;
	private boolean isWorking;

	public Employee(String fName, String lName, int empType, Employee manager) {
		this.fName = fName;
		this.lName = lName;
		this.empType = empType;
		this.manager = manager;
	}

	// Employee Specific Methods
	public void onTheClockCheck(int clockIn) throws Exception {
		if (this.isWorking == true && clockIn == 1) {
			throw new ClockInException("Employee '" + this.fName + " " + this.lName + "' is already working");
		} else if (this.isWorking == false && clockIn == 0) {
			throw new ClockInException("Employee '" + this.fName + " " + this.lName + "' is already not working");
		}

		if (clockIn == 1) {
			this.isWorking = true;
			this.ms.startShift();
		} else if (clockIn == 0) {
			this.isWorking = false;
			this.ms.endShift();
		} else {
			throw new Exception("Shouldn't be here");
		}
	}

	// Getters and Setters
	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public int getEmpId() {
		return empId;
	}

	public MonthShift getMs() {
		return ms;
	}

	public Employee getManager() {
		return manager;
	}

	public int getEmpType() {
		return empType;
	}
}
	/*
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
	
	
	
}*/
