package com.wipro.entity;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class OrderMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderMasterId;
    
    private LocalDate orderDate;
    private OrderStatus status;
    
    private Double totalPrice;
    private Double finalPriceAfterDiscount;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    private CustomerDetails customer;

    @ManyToOne
    @JoinColumn(name = "couponDetails_id", nullable = true)
    private CouponDetails couponDetails;
//    
//    @OneToMany(mappedBy = "orderMaster", cascade = CascadeType.ALL)
//    private List<OrderDetails> orderDetails;

	public Integer getOrderMasterId() {
		return orderMasterId;
	}

	public void setOrderMasterId(Integer orderMasterId) {
		this.orderMasterId = orderMasterId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
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

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	public CouponDetails getCouponDetails() {
		return couponDetails;
	}

	public void setCouponDetails(CouponDetails couponDetails) {
		this.couponDetails = couponDetails;
	}

//	public List<OrderDetails> getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(List<OrderDetails> orderDetails) {
//		this.orderDetails = orderDetails;
//	}

	
}
