package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MonthlySalaryDTO;

public interface IMonthlySalaryService extends IGeneralService<MonthlySalaryDTO> {
    public List<MonthlySalaryDTO> getMonthlySalariesByMonthId(Integer monthId);
}
