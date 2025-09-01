package com.wipro.payload;

import com.wipro.entity.CrustType;
import com.wipro.entity.PizzaSize;
import com.wipro.entity.PizzaType;
import com.wipro.entity.Toppings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaRequestPayload {
	private String name;
    private PizzaType type;  
    private PizzaSize pizzaSize;  
    private Double price;
    private String description;
    private String imageUrl;
    private CrustType crustType;
    private Toppings toppings;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PizzaType getType() {
		return type;
	}
	public void setType(PizzaType type) {
		this.type = type;
	}
	public PizzaSize getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(PizzaSize pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public CrustType getCrustType() {
		return crustType;
	}
	public void setCrustType(CrustType crustType) {
		this.crustType = crustType;
	}
	public Toppings getToppings() {
		return toppings;
	}
	public void setToppings(Toppings toppings) {
		this.toppings = toppings;
	}
    
    
	
   
}
