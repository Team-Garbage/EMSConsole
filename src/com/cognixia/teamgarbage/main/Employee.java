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