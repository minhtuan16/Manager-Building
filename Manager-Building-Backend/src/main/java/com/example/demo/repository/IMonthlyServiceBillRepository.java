package com.example.demo.repository;

import com.example.demo.entity.MonthlyServiceBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMonthlyServiceBillRepository extends JpaRepository<MonthlyServiceBillEntity, Integer> {
     List<MonthlyServiceBillEntity> findMonthlyServiceBillEntitiesByMonth_IdAndServiceContract_Id(Integer monthId,Integer serviceContractId);
}