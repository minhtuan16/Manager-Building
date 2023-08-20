package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MonthEntity;

public interface IMonthRepository extends JpaRepository<MonthEntity, Integer> {
}