package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MonthDTO;
import com.example.demo.entity.MonthEntity;
import com.example.demo.repository.IMonthRepository;
import com.example.demo.service.IMonthService;

@Service
public class MonthService implements IMonthService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IMonthRepository monthRepository;

    @Override
    public List<MonthDTO> findAll() {
        // Gọi repo lấy từ db
        List<MonthEntity> monthEntities = monthRepository.findAll();

        //Chuyển các entities thành các đối tượng Data Transfer Object(DTO) rồi trả về cho controller
        List<MonthDTO> monthDTOS = monthEntities.stream().map(monthEntity -> modelMapper.map(monthEntity, MonthDTO.class))
                .collect(Collectors.toList());
        return monthDTOS;
    }

    @Override
    public Optional<MonthDTO> findById(Integer id) {
        // Gọi repo lấy dữ liệu entity từ db
        Optional<MonthEntity> monthEntity = monthRepository.findById(id);

        //Chuyển entity thành DTO rồi trả về cho controller:
        Optional<MonthDTO> monthDTOOptional = monthEntity.map(monthEntity1 -> modelMapper.map(monthEntity1, MonthDTO.class));
        return monthDTOOptional;
    }

    @Override
    public MonthDTO save(MonthDTO monthDTO) {
        // Chuyển DTO thành entity
        MonthEntity monthEntity = modelMapper.map(monthDTO, MonthEntity.class);

        // Lưu xuống db và trả về đối tượng entity đã được cập nhật
        MonthEntity updatedMonthEntity = monthRepository.save(monthEntity);

        // Chuyển lại đối tượng entity đã được cập nhật sang DTO để trả về:
        return modelMapper.map(updatedMonthEntity,MonthDTO.class);
    }


    @Override
    public void remove(Integer id) {
        monthRepository.deleteById(id);
    }
}
