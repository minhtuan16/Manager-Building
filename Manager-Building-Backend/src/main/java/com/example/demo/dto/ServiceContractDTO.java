package com.example.demo.dto;

import lombok.Data;
// dki them dich vu cho cty
//@Data
public class ServiceContractDTO {
	private int id;

	private String startDate;

	private String description;

	private double currentPrice;

	private ServiceDTO service;

	private CompanyDTO company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public ServiceDTO getService() {
		return service;
	}

	public void setService(ServiceDTO service) {
		this.service = service;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	
}
