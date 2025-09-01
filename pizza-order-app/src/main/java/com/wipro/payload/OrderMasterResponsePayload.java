package com.wipro.payload;
import java.time.LocalDate;
import java.util.List;

import com.wipro.entity.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMasterResponsePayload {
    private Integer orderMasterId;
    private CustomerResponsePayload customer;
    private CouponResponsePayload couponDetails;
    private OrderStatus status;
    private LocalDate orderDate;
    private Double totalPrice;
    private Double finalPriceAfterDiscount;
    private List<OrderResponsePayload> orderDetails;
    
    
	public Integer getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(Integer orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
	public CustomerResponsePayload getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerResponsePayload customer) {
		this.customer = customer;
	}
	public CouponResponsePayload getCouponDetails() {
		return couponDetails;
	}
	public void setCouponDetails(CouponResponsePayload couponDetails) {
		this.couponDetails = couponDetails;
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
