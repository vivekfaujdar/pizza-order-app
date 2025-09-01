package com.wipro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.PizzaDetails;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.payload.PizzaRequestPayload;
import com.wipro.payload.PizzaResponsePayload;
import com.wipro.repository.PizzaRepository;

@Service
public class PizzaDetailsServiceImpl implements PizzaDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(PizzaDetailsServiceImpl.class);
	
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public PizzaResponsePayload createPizza(PizzaRequestPayload pizzaDetailsRequest) {
    	logger.info("creating new Pizza with Name: "+ pizzaDetailsRequest.getName());
        PizzaDetails pizza = new PizzaDetails();
        
        pizza.setName(pizzaDetailsRequest.getName());
        pizza.setImageUrl(pizzaDetailsRequest.getImageUrl());
        pizza.setType(pizzaDetailsRequest.getType());
        pizza.setPizzaSize(pizzaDetailsRequest.getPizzaSize());
        pizza.setCrustType(pizzaDetailsRequest.getCrustType());
        pizza.setToppings(pizzaDetailsRequest.getToppings());
        pizza.setPrice(pizzaDetailsRequest.getPrice());
        pizza.setDescription(pizzaDetailsRequest.getDescription());
        
        PizzaDetails savedPizza = pizzaRepository.save(pizza);
        return mapToResponse(savedPizza);
    }

    @Override
    public PizzaResponsePayload updatePizza(Integer pizzaId, PizzaRequestPayload pizzaDetailsRequest) {
    	logger.info("Updating coupon with ID: {}", pizzaId);
        PizzaDetails pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza not found"));
        
        pizza.setName(pizzaDetailsRequest.getName());
        pizza.setImageUrl(pizzaDetailsRequest.getImageUrl());
        pizza.setType(pizzaDetailsRequest.getType());
        pizza.setPizzaSize(pizzaDetailsRequest.getPizzaSize());
        pizza.setCrustType(pizzaDetailsRequest.getCrustType());
        pizza.setToppings(pizzaDetailsRequest.getToppings());
        pizza.setPrice(pizzaDetailsRequest.getPrice());
        pizza.setDescription(pizzaDetailsRequest.getDescription());
        
        PizzaDetails updatedPizza = pizzaRepository.save(pizza);
        return mapToResponse(updatedPizza);
    }

    @Override
    public PizzaResponsePayload getPizzaById(Integer pizzaId) {
    	logger.info("fetching pizza with ID: "+ pizzaId);
        PizzaDetails pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pizza not found"));
        return mapToResponse(pizza);
    }

    @Override
    public List<PizzaResponsePayload> getAllPizzas() {
    	logger.info("fetching all pizzas");
        List<PizzaDetails> pizzas = pizzaRepository.findAll();
        return pizzas.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deletePizza(Integer pizzaId) {
    	logger.info("Deleting all pizzas with ID: "+ pizzaId);
    	pizzaRepository.deleteById(pizzaId);
    }

    public PizzaResponsePayload mapToResponse(PizzaDetails pizza) {
    	PizzaResponsePayload response = new PizzaResponsePayload();
    	
        response.setId(pizza.getPizzaId());
        response.setName(pizza.getName());
        response.setImageUrl(pizza.getImageUrl());
        response.setType(pizza.getType());
        response.setPizzaSize(pizza.getPizzaSize());
        response.setCrustType(pizza.getCrustType());
        response.setToppings(pizza.getToppings());
        response.setPrice(pizza.getPrice());
        response.setDescription(pizza.getDescription());
        return response;
    }
}
