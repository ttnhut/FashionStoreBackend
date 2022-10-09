/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.controllers;

import com.team.fashionStore.payloads.JWTAuthRequest;
import com.team.fashionStore.security.JWTAuthResponse;
import com.team.fashionStore.security.JWTTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.team.fashionStore.exceptions.ApiException;
import com.team.fashionStore.payloads.UserDto;
import com.team.fashionStore.pojo.User;
import com.team.fashionStore.services.UserService;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private JWTTokenHelper jWTTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> createToken(@RequestBody JWTAuthRequest request) throws Exception{
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        
        String token = this.jWTTokenHelper.generateToken(userDetails);
        
        JWTAuthResponse res = new JWTAuthResponse();
        res.setToken(token);
        res.setUser(this.modelMapper.map((User)userDetails, UserDto.class));
        return ResponseEntity.ok(res);
    }
    
    private void authenticate(String username, String password) throws Exception{
        UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(username, password);
        
      
        try{
            this.authenticationManager.authenticate(u);
        }catch(BadCredentialsException e){
            System.out.println("Invalid Detials");
            throw new ApiException("Invalid username or password");
        }
        
       
           
    }
    
    //register new user
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto user){
        return new ResponseEntity<>(this.userService.registerNewUser(user),HttpStatus.CREATED);
    }
    
}
