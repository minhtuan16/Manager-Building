package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MonthlyBillDTO;
import com.example.demo.service.IMonthlyBillService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/monthlyBills", produces = "application/json")
public class MonthlyBillController {
    @Autowired
    private IMonthlyBillService monthlyBillService;

    @GetMapping("/get-monthly-bill-by-company-and-month")
    private ResponseEntity<List<MonthlyBillDTO>> getMonthlyBillsByCompanyIdAndMonthId(@RequestParam Integer companyId,
                                                                                      @RequestParam Integer monthId){
        List<MonthlyBillDTO> monthlyBillsOfCompanyInAMonth = monthlyBillService.findMonthlyBillsOfCompanyInAMonth(companyId, monthId);
        return new ResponseEntity<>(monthlyBillsOfCompanyInAMonth,HttpStatus.OK);
    }
}
