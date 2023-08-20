package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SalaryDAO;
import com.example.demo.dto.SalaryDTO;
import com.example.demo.entity.SalaryEntity;
import com.example.demo.repository.ISalaryRepository;
import com.example.demo.service.ISalaryService;

@Service
public class SalaryService implements ISalaryService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ISalaryRepository salaryRepository;

    @Autowired
    private SalaryDAO salaryDAO;

    @Override
    public List<SalaryDTO> findAll() {
        // Gọi repo lấy từ db
        List<SalaryEntity> salaryEntities = salaryRepository.findAll();

        //Chuyển các entities thành các đối tượng Data Transfer Object(DTO) rồi trả về cho controller
        List<SalaryDTO> salaryDTOS = salaryEntities.stream().map(salaryEntity -> modelMapper.map(salaryEntity, SalaryDTO.class))
                .collect(Collectors.toList());
        return salaryDTOS;
    }

    @Override
    public Optional<SalaryDTO> findById(Integer id) {
        // Gọi repo lấy dữ liệu entity từ db
        Optional<SalaryEntity> salaryEntity = salaryRepository.findById(id);

        //Chuyển entity thành DTO rồi trả về cho controller:
        Optional<SalaryDTO> salaryDTOOptional = salaryEntity.map(salaryEntity1 -> modelMapper.map(salaryEntity1, SalaryDTO.class));
        return salaryDTOOptional;
    }

    @Override
    public SalaryDTO save(SalaryDTO salaryDTO) {
        // Chuyển DTO thành entity
        SalaryEntity salaryEntity = modelMapper.map(salaryDTO, SalaryEntity.class);

        // Lưu xuống db và trả về đối tượng entity đã được cập nhật
        SalaryEntity updatedSalaryEntity = salaryRepository.save(salaryEntity);

        // Chuyển lại đối tượng entity đã được cập nhật sang DTO để trả về:
        return modelMapper.map(updatedSalaryEntity,SalaryDTO.class);
    }


    @Override
    public void remove(Integer id) {
        salaryRepository.deleteById(id);
    }

    @Override
    public List<SalaryDTO> findSalariesByServiceId(Integer serviceId) {
        List<SalaryEntity> salaryEntityList= salaryRepository.findSalaryEntitiesByService_Id(serviceId);

        //Đổi sang dto
        return salaryEntityList.stream()
                .map(salaryEntity -> modelMapper.map(salaryEntity,SalaryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createNewSalaryByServiceId(Integer serviceId, SalaryDTO salaryDTO) {
        salaryDAO.createSalaryForService(serviceId,salaryDTO);
    }
}
