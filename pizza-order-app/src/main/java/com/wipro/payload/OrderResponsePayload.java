package com.wipro.payload;

public class OrderResponsePayload {
    private Integer id;
    private PizzaResponsePayload pizza;
    private OrderMasterResponsePayload orderMaster;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PizzaResponsePayload getPizza() {
		return pizza;
	}
	public void setPizza(PizzaResponsePayload pizza) {
		this.pizza = pizza;
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
	public OrderMasterResponsePayload getOrderMaster() {
		return orderMaster;
	}
	public void setOrderMaster(OrderMasterResponsePayload orderMaster) {
		this.orderMaster = orderMaster;
	}
    
    
}
