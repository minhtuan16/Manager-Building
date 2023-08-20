package com.example.demo.dto;

import lombok.Data;

//@Data
public class SalaryDTO {
    
	private int id;
    
	private int salaryLevel;
    
	private double salary;
    
	private ServiceDTO service;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalaryLevel() {
		return salaryLevel;
	}

	public void setSalaryLevel(int salaryLevel) {
		this.salaryLevel = salaryLevel;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ServiceDTO getService() {
		return service;
	}

	public void setService(ServiceDTO service) {
		this.service = service;
	}
	
}
