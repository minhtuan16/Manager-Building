package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.WorkDTO;

public interface IWorkService extends IGeneralService<WorkDTO> {
    void createNewWork(Integer empId, WorkDTO workDTO);
    void updateWork(Integer workId, Integer empId, WorkDTO workDTO);
    List<WorkDTO> findWorkByTitle(String title);
    List<WorkDTO> findWorkByBuildingEmployeeId(Integer empId);
    List<WorkDTO> findWorkByTitleContainingAndBuildingEmployeeId(String title, Integer id);
}
