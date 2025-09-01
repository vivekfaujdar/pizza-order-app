package com.wipro.service;

import java.util.List;

import com.wipro.payload.OrderRequestPayload;
import com.wipro.payload.OrderResponsePayload;

public interface OrderDetailsService {
    OrderResponsePayload createOrderDetails(OrderRequestPayload orderDetailsRequest);
    OrderResponsePayload updateOrderDetails(Integer orderDetailsId, OrderRequestPayload orderDetailsRequest);
    OrderResponsePayload getOrderDetailsById(Integer orderDetailsId);
    List<OrderResponsePayload> getAllOrderDetails();
    void deleteOrderDetails(Integer orderDetailsId);
}
