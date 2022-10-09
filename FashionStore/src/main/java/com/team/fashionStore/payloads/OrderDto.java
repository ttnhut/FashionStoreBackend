/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.payloads;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author Asus
 */
public class OrderDto {
    
    private int id;  
    private Date createdDate;     
    private UserDto user;
    

    public OrderDto() {
    }

    public OrderDto(int id, Date createdDate, UserDto user) {
        this.id = id;
        this.createdDate = createdDate;
        this.user = user;
       
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    /**
     * @return the orderDetails
     */
   
    
    
}
