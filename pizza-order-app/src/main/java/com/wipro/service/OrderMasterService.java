package com.wipro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.entity.OrderMaster;

public interface OrderMasterService {
//    OrderMasterResponsePayload createOrder(OrderMasterRequestPayload orderMasterRequest);
//    OrderMasterResponsePayload updateOrder(Integer orderMasterId, OrderMasterRequestPayload orderMasterRequest);
//    OrderMasterResponsePayload getOrderById(Integer orderMasterId);
//    List<OrderMasterResponsePayload> getAllOrders();
//    void deleteOrder(Integer orderMasterId);
	
	 OrderMaster createOrder(OrderMaster orderMaster);
	    Optional<OrderMaster> getOrderById(Integer id);
	    List<OrderMaster> getAllOrders();
	    OrderMaster updateOrder(Integer id, OrderMaster orderMaster);
	    void deleteOrder(Integer id);
}
