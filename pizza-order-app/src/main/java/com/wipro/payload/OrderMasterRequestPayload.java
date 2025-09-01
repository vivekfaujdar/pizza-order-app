package com.wipro.payload;

import java.time.LocalDate;
import java.util.List;

import com.wipro.entity.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMasterRequestPayload {
    private Integer customerId;
    private Integer couponDetailsId;
    private OrderStatus status; 
    private LocalDate orderDate;
    private Double totalPrice;
    private Double finalPriceAfterDiscount;
    private List<OrderResponsePayload> orderDetails;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCouponDetailsId() {
		return couponDetailsId;
	}
	public void setCouponDetailsId(Integer couponDetailsId) {
		this.couponDetailsId = couponDetailsId;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getFinalPriceAfterDiscount() {
		return finalPriceAfterDiscount;
	}
	public void setFinalPriceAfterDiscount(Double finalPriceAfterDiscount) {
		this.finalPriceAfterDiscount = finalPriceAfterDiscount;
	}
	public List<OrderResponsePayload> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderResponsePayload> orderDetails) {
		this.orderDetails = orderDetails;
	}

    
}
