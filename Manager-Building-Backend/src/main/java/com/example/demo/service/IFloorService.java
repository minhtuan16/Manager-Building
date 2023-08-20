package com.example.demo.service;

import com.example.demo.dto.FloorDTO;

public interface IFloorService extends IGeneralService<FloorDTO> {
    double getTheRestAreaOfFloor(Integer floorId);
}
