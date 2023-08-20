package com.example.demo.service;


import java.util.List;

import com.example.demo.dto.ServiceDTO;

public interface IServiceService extends IGeneralService<ServiceDTO> {
     List<ServiceDTO> findAllUnregisterdServices(Integer companyId);
     List<ServiceDTO> findAllUnregisterdServicesByServiceName(Integer companyId, String serviceName);
     List<ServiceDTO> findServicesByName(String name);
}
