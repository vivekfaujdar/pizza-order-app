package com.wipro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.AdminDetails;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.payload.AdminLoginRequest;
import com.wipro.payload.AdminLoginResponse;
import com.wipro.payload.AdminRequestPayload;
import com.wipro.payload.AdminResponsePayload;
import com.wipro.repository.AdminRepository;

@Service
public class AdminDetailsServiceImpl implements AdminDetailsService {

    

	@Autowired
    private AdminRepository adminRepository;

    
//    @Override
//    public AdminLoginResponse authenticateAdmin(AdminLoginRequest loginRequest) {
//        String email = loginRequest.getEmail();
//        String password = loginRequest.getPassword();
//        
//        AdminDetails admin = adminRepository.findByEmail(email);
//
//        if (admin != null && admin.getPassword().equals(password)) {
//            // Generate a JWT token and return it in the response
//            String token = jwtTokenProvider.generateToken(admin.getEmail());
//            return new AdminLoginResponse(token);
//        }
//        return null; // Or handle the invalid login case appropriately
//    }

    @Override
    public Optional<AdminLoginResponse> authenticateAdmin(AdminLoginRequest loginRequest) {
        AdminDetails admin = adminRepository.findByEmail(loginRequest.getEmail());

        if (admin != null && admin.getPassword().equals(loginRequest.getPassword())) {
            // Return a response payload with a success message (or token if using JWT)
            return Optional.of(new AdminLoginResponse("Login successful"));
        } else {
            // Return an empty Optional if authentication fails
            return Optional.empty();
        }
    }

    @Override
    public AdminResponsePayload createAdmin(AdminRequestPayload adminDetailsRequest) {
        AdminDetails admin = new AdminDetails();
        admin.setName(adminDetailsRequest.getName());
        admin.setMobile(adminDetailsRequest.getMobile());
        admin.setAddress(adminDetailsRequest.getAddress());
        admin.setEmail(adminDetailsRequest.getEmail());
        admin.setPassword(adminDetailsRequest.getPassword());

        AdminDetails savedAdmin = adminRepository.save(admin);
        return mapToResponse(savedAdmin);
    }

    @Override
    public AdminResponsePayload updateAdmin(Integer adminId, AdminRequestPayload adminDetailsRequest) {
        AdminDetails admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found"));

        admin.setName(adminDetailsRequest.getName());
        admin.setMobile(adminDetailsRequest.getMobile());
        admin.setAddress(adminDetailsRequest.getAddress());
        admin.setEmail(adminDetailsRequest.getEmail());
        admin.setPassword(adminDetailsRequest.getPassword());

        AdminDetails updatedAdmin = adminRepository.save(admin);
        return mapToResponse(updatedAdmin);
    }

    @Override
    public AdminResponsePayload getAdminById(Integer adminId) {
        AdminDetails admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found"));
        return mapToResponse(admin);
    }

    @Override
    public List<AdminResponsePayload> getAllAdmins() {
        List<AdminDetails> admins = adminRepository.findAll();
        return admins.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteAdmin(Integer adminId) {
    	adminRepository.deleteById(adminId);
    }

    private AdminResponsePayload mapToResponse(AdminDetails admin) {
    	AdminResponsePayload response = new AdminResponsePayload();
        response.setId(admin.getAdminId());
        response.setName(admin.getName());
        response.setMobile(admin.getMobile());
        response.setAddress(admin.getAddress());
        response.setEmail(admin.getEmail());
        return response;
    }
    
    @Override
    public AdminResponsePayload getAdminByEmail(String email) {
        AdminDetails admin = adminRepository.findByEmail(email);
          //  .orElseThrow(() -> new ResourceNotFoundException("Admin not found with email: " + email));
        
        return mapToResponse(admin);
    }

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		AdminDetails admin = adminRepository.findByEmail(email);
//	            //.orElseThrow(() -> new UsernameNotFoundException("Admin not found with email: " + email));
//		
//		List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(admin.getRole().getName()));
//		
//	        return new org.springframework.security.core.userdetails.User(
//	            admin.getEmail(),
//	            admin.getPassword(),
//	            authorities 
//	        );
//	}
}
