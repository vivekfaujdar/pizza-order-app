package com.wipro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    
    private Integer quantity;
    
    private Double unitPrice;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "orderMaster_id", nullable = true)
    private OrderMaster orderMaster;
    
    @ManyToOne
    @JoinColumn(name="pizza_id", nullable = true)
    private PizzaDetails pizza;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderMaster getOrderMaster() {
		return orderMaster;
	}

	public void setOrderMaster(OrderMaster orderMaster) {
		this.orderMaster = orderMaster;
	}

	public PizzaDetails getPizza() {
		return pizza;
	}

	public void setPizza(PizzaDetails pizza) {
		this.pizza = pizza;
	}
    
    


}