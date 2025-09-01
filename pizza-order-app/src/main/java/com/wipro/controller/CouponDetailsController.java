package com.wipro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.payload.CouponRequestPayload;
import com.wipro.payload.CouponResponsePayload;
import com.wipro.service.CouponDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/coupons")
public class CouponDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(CouponDetailsController.class);

    @Autowired
    private CouponDetailsService couponDetailsService;

    @PostMapping
    public ResponseEntity<CouponResponsePayload> createCoupon(@RequestBody CouponRequestPayload couponDetailsRequest) {
        logger.info("Creating new coupon with code: {}", couponDetailsRequest.getCouponCode());

        CouponResponsePayload couponDetailsResponse = couponDetailsService.createCoupon(couponDetailsRequest);

        logger.debug("Coupon created successfully with ID: {}", couponDetailsResponse.getCouponId());
        return new ResponseEntity<>(couponDetailsResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponResponsePayload> updateCoupon(
            @PathVariable Integer id, @RequestBody CouponRequestPayload couponDetailsRequest) {
        logger.info("Updating coupon with ID: {}", id);

        CouponResponsePayload couponDetailsResponse = couponDetailsService.updateCoupon(id, couponDetailsRequest);

        logger.debug("Coupon with ID: {} updated successfully", id);
        return new ResponseEntity<>(couponDetailsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponResponsePayload> getCouponById(@PathVariable Integer id) {
        logger.info("Fetching coupon details for ID: {}", id);

        CouponResponsePayload couponDetailsResponse = couponDetailsService.getCouponById(id);

        logger.debug("Fetched coupon details: {}", couponDetailsResponse);
        return new ResponseEntity<>(couponDetailsResponse, HttpStatus.OK);
    }

    @GetMapping("/code/{couponCode}")
    public ResponseEntity<CouponResponsePayload> getCouponByCode(@PathVariable String couponCode) {
        logger.info("Fetching coupon details for code: {}", couponCode);

        CouponResponsePayload couponDetailsResponse = couponDetailsService.getCouponByCode(couponCode);

        logger.debug("Fetched coupon details: {}", couponDetailsResponse);
        return new ResponseEntity<>(couponDetailsResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CouponResponsePayload>> getAllCoupons() {
        logger.info("Fetching all coupons");

        List<CouponResponsePayload> coupons = couponDetailsService.getAllCoupons();

        logger.debug("Fetched {} coupons", coupons.size());
        return new ResponseEntity<>(coupons, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Integer id) {
        logger.info("Deleting coupon with ID: {}", id);

        couponDetailsService.deleteCoupon(id);

        logger.debug("Coupon with ID: {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
