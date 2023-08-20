package com.example.demo.dto;

import lombok.Data;

//@Data
public class MonthlyServiceBillDTO {
	private int id;

	private double totalAmount;

	private ServiceContractDTO serviceContract;

	private MonthDTO month;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ServiceContractDTO getServiceContract() {
		return serviceContract;
	}

	public void setServiceContract(ServiceContractDTO serviceContract) {
		this.serviceContract = serviceContract;
	}

	public MonthDTO getMonth() {
		return month;
	}

	public void setMonth(MonthDTO month) {
		this.month = month;
	}
	
}
