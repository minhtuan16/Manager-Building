package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MonthlyBillDTO;

public interface IMonthlyBillService {
    List<MonthlyBillDTO> findMonthlyBillsOfCompanyInAMonth(Integer companyId, Integer monthId);
}
