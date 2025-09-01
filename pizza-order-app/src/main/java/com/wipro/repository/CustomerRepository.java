package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.AdminDetails;
import com.wipro.entity.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer> {
	CustomerDetails findByEmail(String email);
}