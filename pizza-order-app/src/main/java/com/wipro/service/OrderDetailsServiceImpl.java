package com.wipro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.OrderDetails;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.payload.OrderRequestPayload;
import com.wipro.payload.OrderResponsePayload;
import com.wipro.repository.OrderMasterRepository;
import com.wipro.repository.OrderRepository;
import com.wipro.repository.PizzaRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderRepository orderDetailsRepository;
    
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private PizzaRepository pizzaRepository;
    
    @Autowired
    private PizzaDetailsServiceImpl pizzaDetailsServiceImpl;
    
    @Autowired
    private OrderMasterServiceImpl orderMasterServiceImpl;
    
    @Override
    public OrderResponsePayload createOrderDetails(OrderRequestPayload orderDetailsRequest) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderMaster(orderMasterRepository.findById(orderDetailsRequest.getOrderMasterId()).orElseThrow(() -> new ResourceNotFoundException("Order Master Details not found")));
        orderDetails.setPizza(pizzaRepository.findById(orderDetailsRequest.getPizzaId()).orElseThrow(() -> new ResourceNotFoundException("Pizza not found")));
        orderDetails.setQuantity(orderDetailsRequest.getQuantity());
        orderDetails.setUnitPrice(orderDetailsRequest.getUnitPrice());
        orderDetails.setTotalPrice((double) orderDetailsRequest.getQuantity() * (orderDetailsRequest.getUnitPrice()));

        OrderDetails savedOrderDetails = orderDetailsRepository.save(orderDetails);
        return mapToResponse(savedOrderDetails);
    }

    @Override
    public OrderResponsePayload updateOrderDetails(Integer orderDetailsId, OrderRequestPayload orderDetailsRequest) {
        OrderDetails orderDetails = orderDetailsRepository.findById(orderDetailsId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Details not found"));

        orderDetails.setOrderMaster(orderMasterRepository.findById(orderDetailsRequest.getOrderMasterId()).orElseThrow(() -> new ResourceNotFoundException("Order Master Details not found")));
        orderDetails.setPizza(pizzaRepository.findById(orderDetailsRequest.getPizzaId()).orElseThrow(() -> new ResourceNotFoundException("Pizza not found")));
        orderDetails.setQuantity(orderDetailsRequest.getQuantity());
        orderDetails.setUnitPrice(orderDetailsRequest.getUnitPrice());
        orderDetails.setTotalPrice((double) orderDetailsRequest.getQuantity() * (orderDetailsRequest.getUnitPrice()));

        OrderDetails updatedOrderDetails = orderDetailsRepository.save(orderDetails);
        return mapToResponse(updatedOrderDetails);
    }

    @Override
    public OrderResponsePayload getOrderDetailsById(Integer orderDetailsId) {
        OrderDetails orderDetails = orderDetailsRepository.findById(orderDetailsId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Details not found"));
        return mapToResponse(orderDetails);
    }

    @Override
    public List<OrderResponsePayload> getAllOrderDetails() {
        List<OrderDetails> orderDetailsList = orderDetailsRepository.findAll();
        return orderDetailsList.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteOrderDetails(Integer orderDetailsId) {
        orderDetailsRepository.deleteById(orderDetailsId);
    }

    private OrderResponsePayload mapToResponse(OrderDetails orderDetails) {
    	OrderResponsePayload response = new OrderResponsePayload();
        response.setId(orderDetails.getOrderId());
        //response.setOrderMaster(orderMasterServiceImpl.mapToResponse(orderDetails.getOrderMaster()));
        response.setPizza(pizzaDetailsServiceImpl.mapToResponse(orderDetails.getPizza()));
        response.setQuantity(orderDetails.getQuantity());
        response.setUnitPrice(orderDetails.getUnitPrice());
        response.setTotalPrice(orderDetails.getTotalPrice());
        return response;
    }
}
