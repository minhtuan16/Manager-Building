package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

//@Data
@Entity
@Table(name = "monthly_salary")
@NoArgsConstructor
public class MonthlySalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double salary;
    
    private String empName;
    
    private String address;
    
    private String phoneNo;
    
    private String position;
    
    private int salaryLevel;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "building_employee_id",nullable = false)
    private BuildingEmployeeEntity buildingEmployee;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalaryLevel() {
		return salaryLevel;
	}

	public void setSalaryLevel(int salaryLevel) {
		this.salaryLevel = salaryLevel;
	}

	public BuildingEmployeeEntity getBuildingEmployee() {
		return buildingEmployee;
	}

	public void setBuildingEmployee(BuildingEmployeeEntity buildingEmployee) {
		this.buildingEmployee = buildingEmployee;
	}

	public MonthEntity getMonth() {
		return month;
	}

	public void setMonth(MonthEntity month) {
		this.month = month;
	}
    
    
}
