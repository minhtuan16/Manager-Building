package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

//@Data
@Entity
@Table(name = "monthly_service_bill")
@NoArgsConstructor
public class MonthlyServiceBillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double totalAmount;
    
    private Date start;
    
    private Date end;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "service_contract_id", nullable = false)
	private ServiceContractEntity serviceContract;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "month_id",nullable = false)
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

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public ServiceContractEntity getServiceContract() {
		return serviceContract;
	}

	public void setServiceContract(ServiceContractEntity serviceContract) {
		this.serviceContract = serviceContract;
	}

	public MonthEntity getMonth() {
		return month;
	}

	public void setMonth(MonthEntity month) {
		this.month = month;
	}
    
    
}
