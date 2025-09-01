package com.wipro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.payload.PizzaRequestPayload;
import com.wipro.payload.PizzaResponsePayload;
import com.wipro.service.PizzaDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/pizzas")
public class PizzaDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(PizzaDetailsController.class);

    @Autowired
    private PizzaDetailsService pizzaDetailsService;

    @PostMapping
    public ResponseEntity<PizzaResponsePayload> createPizza(@RequestBody PizzaRequestPayload pizzaDetailsRequest) {
        logger.info("Received request to create pizza.");
        PizzaResponsePayload pizzaDetailsResponse = pizzaDetailsService.createPizza(pizzaDetailsRequest);
        logger.info("Pizza created successfully.");
        return new ResponseEntity<>(pizzaDetailsResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaResponsePayload> updatePizza(
            @PathVariable Integer id, @RequestBody PizzaRequestPayload pizzaDetailsRequest) {
        logger.info("Received request to update pizza for id: {}", id);
        PizzaResponsePayload pizzaDetailsResponse = pizzaDetailsService.updatePizza(id, pizzaDetailsRequest);
        logger.info("Pizza updated successfully for id: {}", id);
        return new ResponseEntity<>(pizzaDetailsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaResponsePayload> getPizzaById(@PathVariable Integer id) {
        logger.info("Received request to fetch pizza details for id: {}", id);
        PizzaResponsePayload pizzaDetailsResponse = pizzaDetailsService.getPizzaById(id);
        logger.info("Fetched pizza details for id: {}", id);
        return new ResponseEntity<>(pizzaDetailsResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PizzaResponsePayload>> getAllPizzas() {
        logger.info("Received request to fetch all pizzas.");
        List<PizzaResponsePayload> pizzas = pizzaDetailsService.getAllPizzas();
        logger.info("Fetched all pizzas successfully.");
        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Integer id) {
        logger.info("Received request to delete pizza for id: {}", id);
        pizzaDetailsService.deletePizza(id);
        logger.info("Pizza deleted successfully for id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
