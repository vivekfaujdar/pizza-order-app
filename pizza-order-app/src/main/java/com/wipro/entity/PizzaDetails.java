package com.wipro.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pizza_details")
public class PizzaDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pizzaId;
    
    private String name;
    private PizzaType type;
    private PizzaSize pizzaSize;
    private Double price;
    private String description;
    private String imageUrl;
    private CrustType crustType;
    private Toppings toppings;
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
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