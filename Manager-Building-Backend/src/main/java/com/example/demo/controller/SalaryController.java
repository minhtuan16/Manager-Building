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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SalaryDTO;
import com.example.demo.service.ISalaryService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/salaries", produces = "application/json")
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;


    @PostMapping
    public ResponseEntity<SalaryDTO> createNewSalary(@RequestBody SalaryDTO salaryDTO){
        return new ResponseEntity<>(salaryService.save(salaryDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SalaryDTO>> getAllSalarys() {
        return new ResponseEntity<>(salaryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryDTO> getSalaryById(@PathVariable Integer id){
        Optional<SalaryDTO> salary = salaryService.findById(id);
        return salary.map(salaryDTO -> {
            return new ResponseEntity<>(salaryDTO,HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryDTO> updateSalary(@PathVariable Integer id,@RequestBody SalaryDTO salaryDTO){
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để cập nhật, ko thì trả về status not found
        Optional<SalaryDTO> salaryDTOOptional = salaryService.findById(id);

        return salaryDTOOptional.map(salaryDTO1 -> {
            salaryDTO.setId(salaryDTO1.getId());
            SalaryDTO updatedSalary = salaryService.save(salaryDTO);
            return new ResponseEntity<>(updatedSalary,HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SalaryDTO> deleteSalary(@PathVariable Integer id) {
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để xóa, ko thì trả về status not found
        Optional<SalaryDTO> salaryDTOOptional = salaryService.findById(id);
        return salaryDTOOptional.map(salaryDTO -> {
            salaryService.remove(id);
            return new ResponseEntity<>(salaryDTO, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/serviceId={serviceId}")
    public ResponseEntity<List<SalaryDTO>> findSalariesByServiceId(@PathVariable Integer serviceId){
        return new ResponseEntity<>(salaryService.findSalariesByServiceId(serviceId),HttpStatus.OK);
    }

    @PostMapping("/create/serviceId={serviceId}")
    public ResponseEntity<?> createNewSalaryByServiceId(@PathVariable Integer serviceId, @RequestBody SalaryDTO salaryDTO){
        salaryService.createNewSalaryByServiceId(serviceId,salaryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
