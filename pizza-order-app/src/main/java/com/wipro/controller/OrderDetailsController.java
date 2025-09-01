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

import com.wipro.payload.OrderRequestPayload;
import com.wipro.payload.OrderResponsePayload;
import com.wipro.service.OrderDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping
    public ResponseEntity<OrderResponsePayload> createOrderDetails(@RequestBody OrderRequestPayload orderDetailsRequest) {
        logger.info("Received request to create order details.");
        OrderResponsePayload orderDetailsResponse = orderDetailsService.createOrderDetails(orderDetailsRequest);
        logger.info("Order details created successfully.");
        return new ResponseEntity<>(orderDetailsResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponsePayload> updateOrderDetails(
            @PathVariable Integer id, @RequestBody OrderRequestPayload orderDetailsRequest) {
        logger.info("Received request to update order details for id: {}", id);
        OrderResponsePayload orderDetailsResponse = orderDetailsService.updateOrderDetails(id, orderDetailsRequest);
        logger.info("Order details updated successfully for id: {}", id);
        return new ResponseEntity<>(orderDetailsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponsePayload> getOrderDetailsById(@PathVariable Integer id) {
        logger.info("Received request to fetch order details for id: {}", id);
        OrderResponsePayload orderDetailsResponse = orderDetailsService.getOrderDetailsById(id);
        logger.info("Fetched order details for id: {}", id);
        return new ResponseEntity<>(orderDetailsResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponsePayload>> getAllOrderDetails() {
        logger.info("Received request to fetch all order details.");
        List<OrderResponsePayload> orderDetailsList = orderDetailsService.getAllOrderDetails();
        logger.info("Fetched all order details successfully.");
        return new ResponseEntity<>(orderDetailsList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetails(@PathVariable Integer id) {
        logger.info("Received request to delete order details for id: {}", id);
        orderDetailsService.deleteOrderDetails(id);
        logger.info("Order details deleted successfully for id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
