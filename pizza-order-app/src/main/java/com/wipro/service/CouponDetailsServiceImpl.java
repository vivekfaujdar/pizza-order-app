package com.wipro.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.CouponDetails;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.payload.CouponRequestPayload;
import com.wipro.payload.CouponResponsePayload;
import com.wipro.repository.CouponRepository;

@Service
public class CouponDetailsServiceImpl implements CouponDetailsService {

    @Autowired
    private CouponRepository couponDetailsRepository;

    @Override
    public CouponResponsePayload createCoupon(CouponRequestPayload couponDetailsRequest) {
        CouponDetails coupon = new CouponDetails();
        coupon.setCouponCode(couponDetailsRequest.getCouponCode());
        coupon.setDiscountPercentage(couponDetailsRequest.getDiscountPercentage());
        coupon.setExpirationDate(couponDetailsRequest.getExpirationDate());

        CouponDetails savedCoupon = couponDetailsRepository.save(coupon);
        return mapToResponse(savedCoupon);
    }
    @Override
    public CouponResponsePayload getCouponByCode(String couponCode) {
        CouponDetails coupon = couponDetailsRepository.findByCouponCode(couponCode)
                .orElseThrow(() -> new ResourceNotFoundException("Coupon not found with code: " + couponCode));
        return mapToResponse(coupon);
    }

    @Override
    public CouponResponsePayload updateCoupon(Integer couponId, CouponRequestPayload couponDetailsRequest) {
        CouponDetails coupon = couponDetailsRepository.findById(couponId)
                .orElseThrow(() -> new ResourceNotFoundException("Coupon not found"));

        coupon.setCouponCode(couponDetailsRequest.getCouponCode());
        coupon.setDiscountPercentage(couponDetailsRequest.getDiscountPercentage());
        coupon.setExpirationDate(couponDetailsRequest.getExpirationDate());

        CouponDetails updatedCoupon = couponDetailsRepository.save(coupon);
        return mapToResponse(updatedCoupon);
    }

    @Override
    public CouponResponsePayload getCouponById(Integer couponId) {
        CouponDetails coupon = couponDetailsRepository.findById(couponId)
                .orElseThrow(() -> new ResourceNotFoundException("Coupon not found"));
        return mapToResponse(coupon);
    }

    @Override
    public List<CouponResponsePayload> getAllCoupons() {
        List<CouponDetails> coupons = couponDetailsRepository.findAll();
        return coupons.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteCoupon(Integer couponId) {
        couponDetailsRepository.deleteById(couponId);
    }

    public CouponResponsePayload mapToResponse(CouponDetails coupon) {
    	CouponResponsePayload response = new CouponResponsePayload();
        response.setCouponId(coupon.getCouponId());
        response.setCouponCode(coupon.getCouponCode());
        response.setDiscountPercentage(coupon.getDiscountPercentage());
        response.setExpirationDate(coupon.getExpirationDate());
        return response;
    }
}
