package com.example.demo.dto;

import lombok.Data;

//@Data
public class MonthlySalaryDTO {
	private int id;

	private double salary;

	private String empName;

	private String address;

	private String phoneNo;

	private String position;

	private int salaryLevel;

	private MonthDTO month;

	private BuildingEmployeeDTO buildingEmployee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalaryLevel() {
		return salaryLevel;
	}

	public void setSalaryLevel(int salaryLevel) {
		this.salaryLevel = salaryLevel;
	}

	public MonthDTO getMonth() {
		return month;
	}

	public void setMonth(MonthDTO month) {
		this.month = month;
	}

	public BuildingEmployeeDTO getBuildingEmployee() {
		return buildingEmployee;
	}

	public void setBuildingEmployee(BuildingEmployeeDTO buildingEmployee) {
		this.buildingEmployee = buildingEmployee;
	}
	
	
}
