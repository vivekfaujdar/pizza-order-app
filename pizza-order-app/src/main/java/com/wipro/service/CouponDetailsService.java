package com.wipro.service;

import java.util.List;

import com.wipro.payload.CouponRequestPayload;
import com.wipro.payload.CouponResponsePayload;

public interface CouponDetailsService {
    CouponResponsePayload createCoupon(CouponRequestPayload couponDetailsRequest);
    CouponResponsePayload updateCoupon(Integer couponId, CouponRequestPayload couponDetailsRequest);
    CouponResponsePayload getCouponById(Integer couponId);
    List<CouponResponsePayload> getAllCoupons();
    void deleteCoupon(Integer couponId);
    CouponResponsePayload getCouponByCode(String couponCode);
}
