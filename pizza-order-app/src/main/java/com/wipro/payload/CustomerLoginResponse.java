package com.wipro.payload;


public class CustomerLoginResponse { 

    private String token;
//    private Role role;

    public CustomerLoginResponse() {
    	
	}

	public CustomerLoginResponse(String token) {
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
