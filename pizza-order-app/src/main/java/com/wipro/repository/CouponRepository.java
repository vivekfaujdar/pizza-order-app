package com.wipro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.CouponDetails;

@Repository
public interface CouponRepository extends JpaRepository<CouponDetails, Integer> {
	Optional<CouponDetails> findByCouponCode(String couponCode);
}