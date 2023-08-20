package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SalaryDTO;

public interface ISalaryService extends IGeneralService<SalaryDTO> {
    List<SalaryDTO> findSalariesByServiceId(Integer serviceId);

    void createNewSalaryByServiceId(Integer serviceId,SalaryDTO salaryDTO);
}
