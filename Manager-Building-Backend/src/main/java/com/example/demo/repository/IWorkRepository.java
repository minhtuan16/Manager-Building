package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.WorkEntity;

public interface IWorkRepository extends JpaRepository<WorkEntity, Integer> {
    List<WorkEntity> findWorkEntitiesByTitleContaining(String title);
    List<WorkEntity> findWorkEntitiesByBuildingEmployee_Id(Integer id);
    List <WorkEntity> findWorkEntitiesByTitleContainingAndBuildingEmployee_Id(String title, Integer id);
}
