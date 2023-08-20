package com.example.demo.repository;

import com.example.demo.entity.BuildingEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBuildingEmployeeRepository extends JpaRepository<BuildingEmployeeEntity, Integer> {
    List<BuildingEmployeeEntity> findBuildingEmployeeEntitiesByNameContaining(String name);
}