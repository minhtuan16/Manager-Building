package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MessageDTO;
import com.example.demo.dto.ServiceContractDTO;
import com.example.demo.service.IServiceContractService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/service-registrations", produces = "application/json")
public class ServiceContractController {
    @Autowired
    private IServiceContractService serviceContractService;

    @PostMapping
    public ResponseEntity<ServiceContractDTO> createNewServiceContract(@RequestBody ServiceContractDTO serviceContractDTO){
        return new ResponseEntity<>(serviceContractService.save(serviceContractDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ServiceContractDTO>> getAllServiceContracts() {
        return new ResponseEntity<>(serviceContractService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceContractDTO> updateServiceContract(@PathVariable Integer id,@RequestBody ServiceContractDTO serviceContractDTO){
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để cập nhật, ko thì trả về status not found
        Optional<ServiceContractDTO> serviceContractDTOOptional = serviceContractService.findById(id);

        return serviceContractDTOOptional.map(serviceContractDTO1 -> {
            serviceContractDTO.setId(serviceContractDTO1.getId());
            ServiceContractDTO updatedServiceContract = serviceContractService.save(serviceContractDTO);
            return new ResponseEntity<>(updatedServiceContract,HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceContractDTO> deleteServiceContract(@PathVariable Integer id) {
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để xóa, ko thì trả về status not found
        Optional<ServiceContractDTO> serviceContractDTOOptional = serviceContractService.findById(id);
        return serviceContractDTOOptional.map(serviceContractDTO -> {
            serviceContractService.remove(id);
            return new ResponseEntity<>(serviceContractDTO, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/companyId={id}")
    public ResponseEntity<List<ServiceContractDTO>> getAllServiceContractsByCompany(@PathVariable Integer id) {
        return new ResponseEntity<>(serviceContractService.findAllServiceContractOfCompany(id), HttpStatus.OK);
    }

    @PostMapping("/register-new-service")
    public ResponseEntity<ServiceContractDTO> createNewServiceContract(@RequestParam Integer companyId,
                                                                       @RequestParam Integer serviceId,
                                                                       @RequestBody ServiceContractDTO serviceContractDTO){
        Optional<ServiceContractDTO> savedServiceContract = serviceContractService.createServiceContract(companyId, serviceId, serviceContractDTO);

        if(savedServiceContract.isPresent()){
            return new ResponseEntity<>(serviceContractService.save(serviceContractDTO),HttpStatus.OK);
        }
        return new ResponseEntity<>(serviceContractService.save(serviceContractDTO),HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/service-name={serviceName}")
    public ResponseEntity<List<ServiceContractDTO>> getServiceContractsByServiceName(@PathVariable String serviceName){
        return new ResponseEntity<>( serviceContractService.findServiceContractByServiceName(serviceName),HttpStatus.OK);
    }
}
