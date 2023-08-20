package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.ContractDTO;

public interface IContractService extends IGeneralService<ContractDTO> {
     double getSumOfRentedArea(Integer companyId);
     double getSumOfRentedAreaFloor(Integer floorId);
     void createContract(Integer companyId, Integer floorId, ContractDTO contractDTO );
     List<ContractDTO> getContractsByFloorId(Integer floorId);
     List<ContractDTO> getContractsByCompanyId(Integer companyId);
}
