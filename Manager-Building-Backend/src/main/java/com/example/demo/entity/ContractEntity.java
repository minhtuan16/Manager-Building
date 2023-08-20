package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


//@Data
@Entity
@Table(name = "contract")
@NoArgsConstructor
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date rentedDate;
    private Date expiredDate;
    private double rentedArea;
    private String description;
    private int isCanceled;
    private String position;

    @ManyToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

	@ManyToOne
//	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "floor_id")
	private FloorEntity floor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRentedDate() {
		return rentedDate;
	}

	public void setRentedDate(Date rentedDate) {
		this.rentedDate = rentedDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public double getRentedArea() {
		return rentedArea;
	}

	public void setRentedArea(double rentedArea) {
		this.rentedArea = rentedArea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(int isCanceled) {
		this.isCanceled = isCanceled;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public FloorEntity getFloor() {
		return floor;
	}

	public void setFloor(FloorEntity floor) {
		this.floor = floor;
	}

	
}
