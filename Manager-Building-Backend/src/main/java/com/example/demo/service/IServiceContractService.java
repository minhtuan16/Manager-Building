package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ServiceContractDTO;

public interface IServiceContractService extends IGeneralService<ServiceContractDTO> {
    List<ServiceContractDTO> findAllServiceContractOfCompany(Integer companyId);
    Optional<ServiceContractDTO> createServiceContract(Integer companyId, Integer serviceId, ServiceContractDTO serviceContractDTO);
    List<ServiceContractDTO> findServiceContractByServiceName(String serviceName);
}
