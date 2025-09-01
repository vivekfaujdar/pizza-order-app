package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.OrderMaster;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {
}