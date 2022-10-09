/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.team.fashionStore.pojo.Role;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Size;

/**
 *
 * @author Asus
 */
public class UserDto {
    private int id;
    @Size(max=20,min=4, message = "Username must be from 4 to 20 charactors")
    private String username;
    @Size(max=20,min=4, message = "Password must be from 4 to 20 charactors")
    private String password;
    private Set<RoleDto> roles = new HashSet<>();
    public UserDto() {
    }

    public UserDto(int id, String username, String password,Set<RoleDto> roles ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the roles
     */
    public Set<RoleDto> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    
    
}
