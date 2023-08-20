package com.example.demo.dto;

import lombok.Data;

//@Data
public class MonthlyBillDTO {
	private int id;

	private double totalAmount;

	private ContractDTO contract;

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

	public ContractDTO getContract() {
		return contract;
	}

	public void setContract(ContractDTO contract) {
		this.contract = contract;
	}

	public MonthDTO getMonth() {
		return month;
	}

	public void setMonth(MonthDTO month) {
		this.month = month;
	}
	
	
}
