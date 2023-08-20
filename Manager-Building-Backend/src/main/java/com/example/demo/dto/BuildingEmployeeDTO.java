package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

//@Data
public class BuildingEmployeeDTO {
	private int id;

	private String name;

	private Date dateOfBirth;
//	private String dateOfBirth;

	private String address;

	private String phoneNo;

	private String position;

	private SalaryDTO salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public SalaryDTO getSalary() {
		return salary;
	}

	public void setSalary(SalaryDTO salary) {
		this.salary = salary;
	}
	
	
}
