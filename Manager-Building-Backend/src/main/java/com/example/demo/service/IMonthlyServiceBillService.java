package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.MonthlyServiceBillDTO;
import com.example.demo.dto.ServiceContractDTO;


public interface IMonthlyServiceBillService extends IGeneralService<MonthlyServiceBillDTO> {
    double calculateMoney(Date startDate, Date endDate, ServiceContractDTO serviceContractDTO);
    List<MonthlyServiceBillDTO> findMonthlyServiceBillsOfCompanyInAMonth(Integer companyId,Integer monthId);
}
