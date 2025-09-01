package com.wipro.service;

import java.util.List;

import com.wipro.payload.PizzaRequestPayload;
import com.wipro.payload.PizzaResponsePayload;

public interface PizzaDetailsService {
	PizzaResponsePayload createPizza(PizzaRequestPayload pizzaDetailsRequest);
	PizzaResponsePayload updatePizza(Integer pizzaId, PizzaRequestPayload pizzaDetailsRequest);
	PizzaResponsePayload getPizzaById(Integer pizzaId);
    List<PizzaResponsePayload> getAllPizzas();
    void deletePizza(Integer pizzaId);
}
