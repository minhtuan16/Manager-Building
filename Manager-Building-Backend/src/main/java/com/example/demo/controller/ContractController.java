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

import com.example.demo.dto.ContractDTO;
import com.example.demo.repository.IFloorRepository;
import com.example.demo.service.IContractService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/rented-areas", produces = "application/json")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IFloorRepository floorRepository;
//    @PostMapping("/{companyId}/{floorId}")
//    public ResponseEntity<ContractDTO> createNewContract(@RequestParam Integer companyId,
//                                                         @RequestParam Integer floorId,
//                                                         @RequestBody ContractDTO contractDTO) {
//        Double sumOfRentedArea = contractService.getSumOfRentedAreaFloor(floorId);
//        if (contractDTO.getRentedArea() <= (floorRepository.getById(floorId).getGroundArea() - sumOfRentedArea))
//        {
//            contractService.createContract(companyId, floorId, contractDTO);
//            return new ResponseEntity<>(contractService.save(contractDTO),HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(contractService.save(contractDTO), HttpStatus.EXPECTATION_FAILED);
//
//
//    }

    @PostMapping("/companyId={companyId}/floorId={floorId}")
    public ResponseEntity<ContractDTO> createNewContract(@PathVariable Integer companyId,
                                                         @PathVariable Integer floorId,
                                                         @RequestBody ContractDTO contractDTO) {
        Double sumOfRentedArea = contractService.getSumOfRentedAreaFloor(floorId);
        if (contractDTO.getRentedArea() <= (floorRepository.getById(floorId).getGroundArea() - sumOfRentedArea))
        {
            contractService.createContract(companyId, floorId, contractDTO);
            return new ResponseEntity<>(contractService.save(contractDTO),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(contractService.save(contractDTO), HttpStatus.EXPECTATION_FAILED);


    }

    @GetMapping
    public ResponseEntity<List<ContractDTO>> getAllContracts() {
        return new ResponseEntity<>(contractService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractDTO> updateContract(@PathVariable Integer id,@RequestBody ContractDTO contractDTO){
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để cập nhật, ko thì trả về status not found
        Optional<ContractDTO> contractDTOOptional = contractService.findById(id);

        return contractDTOOptional.map(contractDTO1 -> {
            contractDTO.setId(contractDTO1.getId());
            ContractDTO updatedContract = contractService.save(contractDTO);
            return new ResponseEntity<>(updatedContract,HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContractDTO> deleteContract(@PathVariable Integer id) {
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để xóa, ko thì trả về status not found
        Optional<ContractDTO> contractDTOOptional = contractService.findById(id);
        return contractDTOOptional.map(contractDTO -> {
            contractService.remove(id);
            return new ResponseEntity<>(contractDTO, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/floorId={floorId}")
    public ResponseEntity<List<ContractDTO>> getContractsByFloorId(@PathVariable Integer floorId){
        List<ContractDTO> contractsByFloorId = contractService.getContractsByFloorId(floorId);
        return new ResponseEntity<>(contractsByFloorId,HttpStatus.OK);
    }

    @GetMapping("/companyId={companyId}")
    public ResponseEntity<List<ContractDTO>> getContractsByCompanyId(@PathVariable Integer companyId){
        List<ContractDTO> contractsByFloorId = contractService.getContractsByCompanyId(companyId);
        return new ResponseEntity<>(contractsByFloorId,HttpStatus.OK);
    }
}
