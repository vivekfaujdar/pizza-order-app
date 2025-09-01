package com.wipro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.payload.CustomerLoginRequest;
import com.wipro.payload.CustomerLoginResponse;
import com.wipro.payload.CustomerRequestPayload;
import com.wipro.payload.CustomerResponsePayload;

public interface CustomerDetailsService {
	CustomerResponsePayload createCustomer(CustomerRequestPayload customerDetailsRequest);
	CustomerResponsePayload updateCustomer(Integer customerId, CustomerRequestPayload customerDetailsRequest);
    CustomerResponsePayload getCustomerById(Integer customerId);
    List<CustomerResponsePayload> getAllCustomers();
    void deleteCustomer(Integer customerId);
    Optional<CustomerLoginResponse> authenticateCustomer(CustomerLoginRequest loginRequest);
	CustomerResponsePayload getCustomerByEmail(String email);
}
