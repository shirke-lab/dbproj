package com.example.model.db1;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotBlank(message = "Name is required")
   @Column(name= "name", nullable=false)
    private String name;
   @NotNull 
   @NotBlank
   @Size(min=10, max=10, message="mobile no. must be exactly 10 digits")
   private String mobileNo;
   @Column(unique = true, nullable = false)
   private String userid;
   private String password;
   
   // Getters and Setters
public  String getName() {
	return name;
}
public String getMobileNo() { 
	return mobileNo;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public static class LoginRequest {
	@Column(unique = true, nullable = false)
	private String userid;
    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public static class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
}

