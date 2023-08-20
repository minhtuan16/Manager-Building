package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.MonthlyFeeOfCompanyDTO;

public interface ICompanyService extends IGeneralService<CompanyDTO> {
    List<MonthlyFeeOfCompanyDTO> getMonthlyFeeOfCompany(Integer monthId);
    List<MonthlyFeeOfCompanyDTO> getFeeOfCompanies();
    CompanyDTO update(CompanyDTO companyDTO);
    List<CompanyDTO> findCompaniesByName(String name);
}
