package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CompanyEmployeeDTO;

public interface ICompanyEmployeeService extends IGeneralService<CompanyEmployeeDTO> {
    public List<CompanyEmployeeDTO> findAllEmployeeOfCompany(Integer id);
    public int countCompanyEmployeesByCompanyID(Integer companyId);
    List<CompanyEmployeeDTO> findEmployeesByNameAndCompanyId(String empName,Integer companyId);
}
