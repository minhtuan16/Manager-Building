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

import com.example.demo.dto.FloorDTO;
import com.example.demo.service.IFloorService;

@RestController
@CrossOrigin("*")
    @RequestMapping(value = "/api/floors", produces = "application/json")
public class FloorController {
    @Autowired
    private IFloorService floorService;

    @PostMapping
    public ResponseEntity<FloorDTO> createNewFloor(@RequestBody FloorDTO floorDTO){
        return new ResponseEntity<>(floorService.save(floorDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FloorDTO>> getAllFloors() {
        return new ResponseEntity<>(floorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FloorDTO> getFloorById(@PathVariable Integer id){
        return floorService.findById(id).map(floorDTO ->
                new ResponseEntity<FloorDTO>(floorDTO,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FloorDTO> updateFloor(@PathVariable Integer id,@RequestBody FloorDTO floorDTO){
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để cập nhật, ko thì trả về status not found
        Optional<FloorDTO> floorDTOOptional = floorService.findById(id);

        return floorDTOOptional.map(floorDTO1 -> {
            floorDTO.setId(floorDTO1.getId());
            FloorDTO updatedFloor = floorService.save(floorDTO);
            return new ResponseEntity<>(updatedFloor,HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FloorDTO> deleteFloor(@PathVariable Integer id) {
        // Lấy thử đối tượng có id đó ra xem tồn tại chưa để xóa, ko thì trả về status not found
        Optional<FloorDTO> floorDTOOptional = floorService.findById(id);
        return floorDTOOptional.map(floorDTO -> {
            floorService.remove(id);
            return new ResponseEntity<>(floorDTO, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/available-area/{id}")
    public ResponseEntity<Double> getTheRestAreaOfFloor(@PathVariable Integer id){
        return new ResponseEntity<>(floorService.getTheRestAreaOfFloor(id),HttpStatus.OK);
    }
}
