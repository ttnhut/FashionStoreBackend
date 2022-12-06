/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.payloads;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 *
 * @author Asus
 */
public class CategoryDto implements Serializable{
    
    private int id;
    @NotEmpty
    @Size(min=1,max=20, message = "Name is from 1 to 20 characters")
    private String name;

    public CategoryDto() {
    }
    
    public CategoryDto(String id){
        this.id = Integer.parseInt(id);
    }
    
    public CategoryDto(int id, String name) {
        this.id = id;
        this.name = name;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
     
    
}
