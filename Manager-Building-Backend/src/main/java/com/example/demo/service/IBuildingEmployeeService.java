package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BuildingEmployeeDTO;

public interface IBuildingEmployeeService extends IGeneralService<BuildingEmployeeDTO> {
    void createNewBuildingEmployeeBySalaryId(Integer salaryId, BuildingEmployeeDTO buildingEmployeeDTO);
    void updateBuildingEmployee(Integer empId, Integer salaryId, BuildingEmployeeDTO buildingEmployeeDTO);
    List<BuildingEmployeeDTO> findBuildingEmployeeByName(String name);

}
