package com.wipro.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.AdminDetails;
import com.wipro.entity.CustomerDetails;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.payload.AdminLoginResponse;
import com.wipro.payload.CustomerLoginRequest;
import com.wipro.payload.CustomerLoginResponse;
import com.wipro.payload.CustomerRequestPayload;
import com.wipro.payload.CustomerResponsePayload;
import com.wipro.repository.CustomerRepository;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponsePayload createCustomer(CustomerRequestPayload customerRequest) {
        CustomerDetails customer = new CustomerDetails();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
//        customer.setBirthdate(LocalDate.parse(customerRequest.getBirthdate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        customer.setBirthdate(customerRequest.getBirthdate());
        customer.setMobile(customerRequest.getMobile());
        customer.setAddress(customerRequest.getAddress());
        customer.setPassword(customerRequest.getPassword());

        CustomerDetails savedCustomer = customerRepository.save(customer);
        return mapToResponse(savedCustomer);
    }

    @Override
    public CustomerResponsePayload updateCustomer(Integer customerId, CustomerRequestPayload customerDetailsRequest) {
        CustomerDetails customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        customer.setName(customerDetailsRequest.getName());
        customer.setEmail(customerDetailsRequest.getEmail());
//        customer.setBirthdate(LocalDate.parse(customerDetailsRequest.getBirthdate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        customer.setBirthdate(customerDetailsRequest.getBirthdate());
        customer.setMobile(customerDetailsRequest.getMobile());
        customer.setAddress(customerDetailsRequest.getAddress());
        customer.setPassword(customerDetailsRequest.getPassword());

        CustomerDetails updatedCustomer = customerRepository.save(customer);
        return mapToResponse(updatedCustomer);
    }

    @Override
    public CustomerResponsePayload getCustomerById(Integer customerId) {
        CustomerDetails customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        return mapToResponse(customer);
    }

    @Override
    public List<CustomerResponsePayload> getAllCustomers() {
        List<CustomerDetails> customers = customerRepository.findAll();
        return customers.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Integer customerId) {
    	customerRepository.deleteById(customerId);
    }

    public CustomerResponsePayload mapToResponse(CustomerDetails customer) {
    	CustomerResponsePayload response = new CustomerResponsePayload();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setBirthdate(customer.getBirthdate());
        response.setMobile(customer.getMobile());
        response.setAddress(customer.getAddress());
        return response;
    }

	@Override
	public Optional<CustomerLoginResponse> authenticateCustomer(CustomerLoginRequest loginRequest) {
		CustomerDetails customer = customerRepository.findByEmail(loginRequest.getEmail());

        if (customer != null && customer.getPassword().equals(loginRequest.getPassword())) {
            // Return a response payload with a success message (or token if using JWT)
            return Optional.of(new CustomerLoginResponse("Login successful"));
        } else {
            // Return an empty Optional if authentication fails
            return Optional.empty();
        }
	}

	@Override
	public CustomerResponsePayload getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
