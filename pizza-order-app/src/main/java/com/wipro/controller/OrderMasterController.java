package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.wipro.entity.OrderMaster;
import com.wipro.service.OrderMasterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/orders")
public class OrderMasterController {

    private static final Logger logger = LoggerFactory.getLogger(OrderMasterController.class);

    @Autowired
    private OrderMasterService orderMasterService;

    @PostMapping
    public ResponseEntity<OrderMaster> createOrder(@RequestBody OrderMaster orderMaster) {
    	logger.info("Received request to create an order.");
        OrderMaster createdOrder = orderMasterService.createOrder(orderMaster);
        logger.info("Order created successfully.");
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderMaster> getOrderById(@PathVariable Integer id) {
    	logger.info("Received request to fetch order details for id: {}", id);
        Optional<OrderMaster> orderMaster = orderMasterService.getOrderById(id);
        logger.info("Fetched order details for id: {}", id);
        return orderMaster.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderMaster>> getAllOrders() {
    	logger.info("Received request to fetch all orders.");
        List<OrderMaster> orders = orderMasterService.getAllOrders();
        logger.info("Fetched all orders successfully.");
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderMaster> updateOrder(@PathVariable Integer id, @RequestBody OrderMaster orderMaster) {
    	logger.info("Received request to update order for id: {}", id);
        OrderMaster updatedOrder = orderMasterService.updateOrder(id, orderMaster);
        if (updatedOrder != null) {
        	logger.info("Order updated successfully for id: {}", id);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
    	logger.info("Received request to delete order for id: {}", id);
        orderMasterService.deleteOrder(id);
        logger.info("Order deleted successfully for id: {}", id);
        return ResponseEntity.noContent().build();
    }
}
