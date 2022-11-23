package com.diallo.rest.webservices.restfullservices.Taches.jwt.resource;

import java.io.Serializable;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


//@Component
public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return encode;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String encode = encoder.encode(this.password);
}

