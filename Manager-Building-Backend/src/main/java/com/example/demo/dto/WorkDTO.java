package com.example.demo.dto;

import lombok.Data;

//@Data
public class WorkDTO {
	private int id;

	private String title;

	private String detail;

	private String startDate;

	private String dueDate;

	private String assigner;

	private BuildingEmployeeDTO buildingEmployee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssigner() {
		return assigner;
	}

	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}

	public BuildingEmployeeDTO getBuildingEmployee() {
		return buildingEmployee;
	}

	public void setBuildingEmployee(BuildingEmployeeDTO buildingEmployee) {
		this.buildingEmployee = buildingEmployee;
	}
	
	
}
