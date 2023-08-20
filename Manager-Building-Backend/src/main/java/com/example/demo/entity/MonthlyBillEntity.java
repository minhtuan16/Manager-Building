package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

//@Data
@Entity
@Table(name = "monthly_bill")
@NoArgsConstructor
public class MonthlyBillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double totalAmount;

	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "contract_id", nullable = false)
	private ContractEntity contract;

	@ManyToOne
	@JoinColumn(name = "month_id", nullable = false)
	private MonthEntity month;

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

	public ContractEntity getContract() {
		return contract;
	}

	public void setContract(ContractEntity contract) {
		this.contract = contract;
	}

	public MonthEntity getMonth() {
		return month;
	}

	public void setMonth(MonthEntity month) {
		this.month = month;
	}
	
	
}
