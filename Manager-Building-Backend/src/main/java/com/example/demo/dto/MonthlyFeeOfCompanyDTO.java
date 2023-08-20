package com.example.demo.dto;

import lombok.Data;

//@Data
public class MonthlyFeeOfCompanyDTO {

	private MonthDTO month;

	private double totalAmount;

	private CompanyDTO company;

	public MonthDTO getMonth() {
		return month;
	}

	public void setMonth(MonthDTO month) {
		this.month = month;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	
	
}
