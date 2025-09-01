package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.OrderMaster;
import com.wipro.repository.OrderMasterRepository;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

//    @Autowired
//    private OrderMasterRepository orderMasterRepository;
//    @Autowired
//    private CustomerRepository customerRepository;
//    
//    @Autowired
//    private CouponRepository couponRepository;
//    
//    @Autowired
//    private CustomerDetailsServiceImpl customerDetailsServiceImpl;
//    
//    @Autowired
//    private CouponDetailsServiceImpl couponDetailsServiceImpl;
//    
//    @Override
//    public OrderMasterResponsePayload createOrder(OrderMasterRequestPayload orderMasterRequest) {
//        OrderMaster order = new OrderMaster();
//        order.setCustomer(customerRepository.findById(orderMasterRequest.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
//        order.setCouponDetails(couponRepository.findById(orderMasterRequest.getCouponDetailsId()).orElseThrow(() -> new ResourceNotFoundException("Coupon not found")));
//        order.setStatus(orderMasterRequest.getStatus());
//        order.setTotalPrice(orderMasterRequest.getTotalPrice());
//
//        OrderMaster savedOrder = orderMasterRepository.save(order);
//        return mapToResponse(savedOrder);
//    }
//
//    @Override
//    public OrderMasterResponsePayload updateOrder(Integer orderMasterId, OrderMasterRequestPayload orderMasterRequest) {
//        OrderMaster order = orderMasterRepository.findById(orderMasterId)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
//
//        order.setCustomer(customerRepository.findById(orderMasterRequest.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
//        order.setCouponDetails(couponRepository.findById(orderMasterRequest.getCouponDetailsId()).orElseThrow(() -> new ResourceNotFoundException("Coupon not found")));
//        order.setStatus(orderMasterRequest.getStatus());
//        order.setTotalPrice(orderMasterRequest.getTotalPrice());
//
//        OrderMaster updatedOrder = orderMasterRepository.save(order);
//        return mapToResponse(updatedOrder);
//    }
//
//    @Override
//    public OrderMasterResponsePayload getOrderById(Integer orderMasterId) {
//        OrderMaster order = orderMasterRepository.findById(orderMasterId)
//                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
//        return mapToResponse(order);
//    }
//
//    @Override
//    public List<OrderMasterResponsePayload> getAllOrders() {
//        List<OrderMaster> orders = orderMasterRepository.findAll();
//        return orders.stream().map(this::mapToResponse).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteOrder(Integer orderMasterId) {
//        orderMasterRepository.deleteById(orderMasterId);
//    }
//
//    public OrderMasterResponsePayload mapToResponse(OrderMaster order) {
//    	OrderMasterResponsePayload response = new OrderMasterResponsePayload();
//        response.setOrderMasterId(order.getOrderMasterId());
//        response.setCustomer(customerDetailsServiceImpl.mapToResponse(order.getCustomer()));
//        response.setCouponDetails(couponDetailsServiceImpl.mapToResponse(order.getCouponDetails()));
//        response.setStatus(order.getStatus());
//        response.setTotalPrice(order.getTotalPrice());
//        return response;
//    }
	

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderMaster createOrder(OrderMaster orderMaster) {
        return orderMasterRepository.save(orderMaster);
    }

    @Override
    public Optional<OrderMaster> getOrderById(Integer id) {
        return orderMasterRepository.findById(id);
    }

    @Override
    public List<OrderMaster> getAllOrders() {
        return orderMasterRepository.findAll();
    }

    @Override
    public OrderMaster updateOrder(Integer id, OrderMaster orderMaster) {
        if (orderMasterRepository.existsById(id)) {
            orderMaster.setOrderMasterId(id); // Ensure the existing ID is retained.
            return orderMasterRepository.save(orderMaster);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteOrder(Integer id) {
        orderMasterRepository.deleteById(id);
    }
}
