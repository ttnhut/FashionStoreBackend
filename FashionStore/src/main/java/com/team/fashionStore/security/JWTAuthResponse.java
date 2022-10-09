/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.security;

import com.team.fashionStore.payloads.UserDto;

/**
 *
 * @author Asus
 */
public class JWTAuthResponse {
    private String token;
    private UserDto user;
    public JWTAuthResponse() {
    }

    public JWTAuthResponse(String token) {
        this.token = token;
    }

    public JWTAuthResponse(String token, UserDto user) {
        this.token = token;
        this.user = user;
    }
    

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the user
     */
    public UserDto getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserDto user) {
        this.user = user;
    }
    
}
