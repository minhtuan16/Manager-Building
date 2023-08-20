package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

//@Data
public class ContractDTO {
	private int id;

	private Date rentedDate;
//	private String rentedDate;

	private Date expiredDate;
//	private String expiredDate;

	private double rentedArea;

	private String description;

	private int isCanceled;

	private String position;

	private double currentPrice;

	private CompanyDTO company;

	private FloorDTO floor;

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

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public FloorDTO getFloor() {
		return floor;
	}

	public void setFloor(FloorDTO floor) {
		this.floor = floor;
	}
	
	
}
