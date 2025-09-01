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

import com.wipro.payload.AdminLoginRequest;
import com.wipro.payload.AdminLoginResponse;
import com.wipro.payload.AdminRequestPayload;
import com.wipro.payload.AdminResponsePayload;
import com.wipro.service.AdminDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admins")
public class AdminDetailsController {
    private static final Logger logger = LoggerFactory.getLogger(AdminDetailsController.class);


	@Autowired
	private AdminDetailsService adminDetailsService;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponse> login(@RequestBody AdminLoginRequest loginRequest) {
    	logger.info("Admin login attempt with email: {}", loginRequest.getEmail());

        Optional<AdminLoginResponse> response = adminDetailsService.authenticateAdmin(loginRequest);

        if (response.isPresent()) {
        	logger.debug("Login successful for email: {}", loginRequest.getEmail());
            return ResponseEntity.ok(response.get());
        }else {
        	logger.warn("Invalid login attempt with email: {}", loginRequest.getEmail());
            return ResponseEntity.status(401).body(new AdminLoginResponse("Invalid email or password"));
        }
    }

    @PostMapping
    public ResponseEntity<AdminResponsePayload> createAdmin(@RequestBody AdminRequestPayload adminDetailsRequest) {
    	logger.info("Creating new admin with email: {}", adminDetailsRequest.getEmail());

        AdminResponsePayload adminDetailsResponse = adminDetailsService.createAdmin(adminDetailsRequest);

        // Log admin creation success
        logger.debug("Admin created successfully with ID: {}", adminDetailsResponse.getId());
        return new ResponseEntity<>(adminDetailsResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminResponsePayload> updateAdmin(
            @PathVariable Integer id, @RequestBody AdminRequestPayload adminDetailsRequest) {
    	// Log the update attempt
        logger.info("Updating admin with ID: {}", id);

        AdminResponsePayload adminDetailsResponse = adminDetailsService.updateAdmin(id, adminDetailsRequest);

        // Log success of the update
        logger.debug("Admin with ID: {} updated successfully", id);
        return new ResponseEntity<>(adminDetailsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponsePayload> getAdminById(@PathVariable Integer id) {
        logger.info("Fetching admin details for ID: {}", id);

        AdminResponsePayload adminDetailsResponse = adminDetailsService.getAdminById(id);

        if (adminDetailsResponse != null) {
            logger.debug("Admin details retrieved for ID: {}", id);
        } else {
            logger.warn("No admin found with ID: {}", id);
        }

        return new ResponseEntity<>(adminDetailsResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AdminResponsePayload>> getAllAdmins() {
        logger.info("Fetching all admin details");

        List<AdminResponsePayload> admins = adminDetailsService.getAllAdmins();

        logger.debug("Retrieved {} admins", admins.size());
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) {
        logger.info("Deleting admin with ID: {}", id);

        adminDetailsService.deleteAdmin(id);

        logger.debug("Admin with ID: {} deleted successfully", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
