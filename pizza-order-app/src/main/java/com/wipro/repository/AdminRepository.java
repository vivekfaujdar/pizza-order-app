package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.AdminDetails;

@Repository
public interface AdminRepository extends JpaRepository<AdminDetails, Integer> {
	AdminDetails findByEmail(String email);
}