package com.example.demo.dto;

import lombok.Data;

//@Data
public class CompanyDTO {
	private int id;
	
	private String name;
	
	private String taxCode;
	
	private double authorizedCapital;
	
	private String phoneNo;
	
	private int numberOfEmployee;
	
	private double sumOfRentedArea;
	
	private String activeField;
	
	private String status;

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

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public double getAuthorizedCapital() {
		return authorizedCapital;
	}

	public void setAuthorizedCapital(double authorizedCapital) {
		this.authorizedCapital = authorizedCapital;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public double getSumOfRentedArea() {
		return sumOfRentedArea;
	}

	public void setSumOfRentedArea(double sumOfRentedArea) {
		this.sumOfRentedArea = sumOfRentedArea;
	}

	public String getActiveField() {
		return activeField;
	}

	public void setActiveField(String activeField) {
		this.activeField = activeField;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
