package com.example.demo.repository;

import com.example.demo.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<ContractEntity, Integer> {
    List<ContractEntity> getContractEntitiesByCompany_Id(Integer companyId);
    List<ContractEntity> getContractEntitiesByFloor_Id(Integer floorId);
}