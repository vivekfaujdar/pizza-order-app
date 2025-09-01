package com.wipro.controller;

import java.util.List;
import java.util.Optional;

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

import com.wipro.payload.CustomerLoginRequest;
import com.wipro.payload.CustomerLoginResponse;
import com.wipro.payload.CustomerRequestPayload;
import com.wipro.payload.CustomerResponsePayload;
import com.wipro.service.CustomerDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/customers")
public class CustomerDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @PostMapping("/login")
    public ResponseEntity<CustomerLoginResponse> login(@RequestBody CustomerLoginRequest loginRequest) {
        logger.info("Customer login attempt with email: {}", loginRequest.getEmail());

        Optional<CustomerLoginResponse> response = customerDetailsService.authenticateCustomer(loginRequest);

        if (response.isPresent()) {
            logger.debug("Login successful for email: {}", loginRequest.getEmail());
            return ResponseEntity.ok(response.get());
        } else {
            logger.warn("Invalid login attempt with email: {}", loginRequest.getEmail());
            return ResponseEntity.status(401).body(new CustomerLoginResponse("Invalid email or password"));
        }
    }

    @PostMapping
    public ResponseEntity<CustomerResponsePayload> createCustomer(@RequestBody CustomerRequestPayload customerDetailsRequest) {
        logger.info("Creating new customer with email: {}", customerDetailsRequest.getEmail());

        CustomerResponsePayload customerDetailsResponse = customerDetailsService.createCustomer(customerDetailsRequest);

        logger.debug("Customer created successfully with ID: {}", customerDetailsResponse.getId());
        return new ResponseEntity<>(customerDetailsResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponsePayload> updateCustomer(
            @PathVariable Integer id, @RequestBody CustomerRequestPayload customerDetailsRequest) {
        logger.info("Updating customer with ID: {}", id);

        CustomerResponsePayload customerDetailsResponse = customerDetailsService.updateCustomer(id, customerDetailsRequest);

        logger.debug("Customer with ID: {} updated successfully", id);
        return new ResponseEntity<>(customerDetailsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponsePayload> getCustomerById(@PathVariable Integer id) {
        logger.info("Fetching customer details for ID: {}", id);

        CustomerResponsePayload customerDetailsResponse = customerDetailsService.getCustomerById(id);

        logger.debug("Fetched customer details: {}", customerDetailsResponse);
        return new ResponseEntity<>(customerDetailsResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponsePayload>> getAllCustomers() {
        logger.info("Fetching all customers");

        List<CustomerResponsePayload> customers = customerDetailsService.getAllCustomers();

        logger.debug("Fetched {} customers", customers.size());
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        logger.info("Deleting customer with ID: {}", id);

        customerDetailsService.deleteCustomer(id);

        logger.debug("Customer with ID: {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
