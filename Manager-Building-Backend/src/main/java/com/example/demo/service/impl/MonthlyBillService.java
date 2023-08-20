package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MonthlyBillDTO;
import com.example.demo.repository.IContractRepository;
import com.example.demo.repository.IMonthlyBillRepository;
import com.example.demo.service.IMonthlyBillService;

@Service
public class MonthlyBillService implements IMonthlyBillService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IMonthlyBillRepository monthlyBillRepository;
    @Override
    public List<MonthlyBillDTO> findMonthlyBillsOfCompanyInAMonth(Integer companyId, Integer monthId) {
        List<MonthlyBillDTO> result = new ArrayList<>();

        contractRepository.getContractEntitiesByCompany_Id(companyId)
                .stream().forEach(
                        contractEntity -> {
                            result.addAll(monthlyBillRepository
                                    .findMonthlyBillEntitiesByContract_IdAndAndMonth_Id(contractEntity.getId(),monthId)
                                    .stream().map(monthlyBillEntity -> {
                                        return modelMapper.map(monthlyBillEntity,MonthlyBillDTO.class);
                                    }).collect(Collectors.toList()));
                        }
                );

        return result;
    }
}
