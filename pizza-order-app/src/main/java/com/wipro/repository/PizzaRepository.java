package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.PizzaDetails;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaDetails, Integer> {
}