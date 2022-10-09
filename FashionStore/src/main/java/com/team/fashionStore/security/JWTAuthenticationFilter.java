/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Asus
 */
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTTokenHelper jWTTokenHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestToken = "";
        //1.get token
        if(request.getHeader("Authorization")!=null)
            requestToken = request.getHeader("Authorization");
        
        String username = null;
        String token = null;
        
        if(request!=null && requestToken.startsWith("Bearer")){
            token = requestToken.substring(7);
            try{
                username = this.jWTTokenHelper.getUserNameFromToken(token);
            
            }catch(IllegalArgumentException e){
                System.out.println("Unable to get JWT Token");
            }catch(ExpiredJwtException e){
                System.out.println("JWT Token has Expired");
            }catch(MalformedJwtException e){
                System.out.println("Invalid JWT");
            }
            
            
        }else{
            System.out.println("JWT Token does not begin with Bearer");
        }
        
        // validate user
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            
            if(this.jWTTokenHelper.validateToken(token, userDetails)){
                UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                u.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(u);
            }
            else{
                System.out.println("Invalid JWT Token");
            }
        }else{
            System.out.println("User is null or context is not null");
        }
        filterChain.doFilter(request, response);
    }
    
}
