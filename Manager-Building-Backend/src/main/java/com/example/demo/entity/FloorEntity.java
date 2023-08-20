package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

//@Data
@Entity
@Table(name = "floor")
@NoArgsConstructor
public class FloorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private double pricePerM2;
	
	private double groundArea;

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

	public double getPricePerM2() {
		return pricePerM2;
	}

	public void setPricePerM2(double pricePerM2) {
		this.pricePerM2 = pricePerM2;
	}

	public double getGroundArea() {
		return groundArea;
	}

	public void setGroundArea(double groundArea) {
		this.groundArea = groundArea;
	}
	
	
}
