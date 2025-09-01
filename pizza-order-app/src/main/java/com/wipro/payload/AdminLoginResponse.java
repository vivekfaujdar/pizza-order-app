package com.wipro.payload;


public class AdminLoginResponse {

    private String token;
//    private Role role;

    public AdminLoginResponse() {
    	
	}

	public AdminLoginResponse(String token) {
        this.token = token;
//        this.role=role;
    }

    // Getter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
    
}
