package com.example.demo.repository;


import com.example.demo.entity.FloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFloorRepository extends JpaRepository<FloorEntity, Integer> {
}
