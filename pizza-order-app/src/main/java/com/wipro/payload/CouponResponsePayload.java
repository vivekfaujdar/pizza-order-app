package com.wipro.payload;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponResponsePayload {
	private Integer couponId;
    private String couponCode;
    private Double discountPercentage;
    private LocalDate expirationDate;
    
    
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

    
    
}
