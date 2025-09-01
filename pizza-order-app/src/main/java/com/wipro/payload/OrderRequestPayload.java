package com.wipro.payload;

public class OrderRequestPayload {
	private Integer pizzaId;
	private Integer orderMasterId;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
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
	public Integer getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(Integer orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
    
    
}
