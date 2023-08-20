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

import com.example.demo.dao.BuildingEmployeeDAO;
import com.example.demo.dto.BuildingEmployeeDTO;
import com.example.demo.dto.CompanyEmployeeDTO;
import com.example.demo.entity.SalaryEntity;
import com.example.demo.service.IBuildingEmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/buildingEmployees", produces = "application/json")
public class BuildingEmployeeController {
    @Autowired
    private IBuildingEmployeeService buildingEmployeeService;
    
    @Autowired
    private BuildingEmployeeDAO buildingEmployeeDAO;

    @PostMapping("/create/salaryId={salaryId}")
    public ResponseEntity<?> createNewBuildingEmployeeBySalaryId(@PathVariable Integer salaryId, @RequestBody BuildingEmployeeDTO buildingEmployeeDTO){
        buildingEmployeeService.createNewBuildingEmployeeBySalaryId(salaryId,buildingEmployeeDTO);
        return new ResponseEntity<>(buildingEmployeeService.save(buildingEmployeeDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BuildingEmployeeDTO>> getAllBuildingEmployees() {
        return new ResponseEntity<>(buildingEmployeeService.findAll(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<BuildingEmployeeDTO> getBuildingEmployeeById(@PathVariable Integer id){
        Optional<BuildingEmployeeDTO> be = buildingEmployeeService.findById(id);
        return be.map(buildingEmployeeDTO -> {
            return new ResponseEntity<>(buildingEmployeeDTO,HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<BuildingEmployeeDTO>> getBuildingEmployeeByName(@PathVariable String name){
        List<BuildingEmployeeDTO> buildingEmployeeDTOS = buildingEmployeeService.findBuildingEmployeeByName(name);
        if(buildingEmployeeDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buildingEmployeeDTOS,HttpStatus.OK);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<BuildingEmployeeDTO> updateBuildingEmployee( @PathVariable Integer empId, @RequestBody BuildingEmployeeDTO buildingEmployeeDTO){
//        buildingEmployeeService.updateBuildingEmployee(empId, salaryId, buildingEmployeeDTO);
//        return new ResponseEntity<>(buildingEmployeeDTO, HttpStatus.OK);
    	
    	
    	// Lấy thử đối tượng có id đó ra xem tồn tại chưa để cập nhật, ko thì trả về status not found
    	Optional<BuildingEmployeeDTO> buildingEmployeeDTOOptional = buildingEmployeeService.findById(empId);

        return buildingEmployeeDTOOptional.map(buildingEmployeeDTO1 -> {
        	buildingEmployeeDTO.setId(buildingEmployeeDTO1.getId());
        	BuildingEmployeeDTO updatedBuildingEmployee = buildingEmployeeService.save(buildingEmployeeDTO);
            return new ResponseEntity<>(updatedBuildingEmployee,HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<BuildingEmployeeDTO> deleteBuildingEmployee(@PathVariable Integer id) {
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để xóa, ko thì trả về status not found
        Optional<BuildingEmployeeDTO> buildingEmployeeDTOOptional = buildingEmployeeService.findById(id);
        return buildingEmployeeDTOOptional.map(buildingEmployeeDTO -> {
            buildingEmployeeService.remove(id); 
            return new ResponseEntity<>(buildingEmployeeDTO, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
