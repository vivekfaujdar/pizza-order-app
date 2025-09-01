package com.wipro.service;

import java.util.List;
import java.util.Optional;


import com.wipro.payload.AdminLoginRequest;
import com.wipro.payload.AdminLoginResponse;
import com.wipro.payload.AdminRequestPayload;
import com.wipro.payload.AdminResponsePayload;

public interface AdminDetailsService  {
    AdminResponsePayload createAdmin(AdminRequestPayload adminDetailsRequest);
    AdminResponsePayload updateAdmin(Integer adminId, AdminRequestPayload adminDetailsRequest);
    AdminResponsePayload getAdminById(Integer adminId);
    List<AdminResponsePayload> getAllAdmins();
    void deleteAdmin(Integer adminId);
    Optional<AdminLoginResponse> authenticateAdmin(AdminLoginRequest loginRequest);
//    AdminResponsePayload authenticateAdmin(AdminLoginRequest loginRequest);
    AdminResponsePayload getAdminByEmail(String email);

}
