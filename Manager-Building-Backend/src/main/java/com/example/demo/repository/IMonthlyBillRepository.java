package com.example.demo.repository;

import com.example.demo.entity.MonthlyBillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMonthlyBillRepository extends JpaRepository<MonthlyBillEntity, Integer> {
    List<MonthlyBillEntity> findMonthlyBillEntitiesByContract_IdAndAndMonth_Id(Integer contractId,Integer monthId);
}