/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Asus
 */
public class OrderDetailDto {
    private int id;
      
    private ClothesDto clothes;
    private int quantity;
    
    private OrderDto order;

    public OrderDetailDto() {
    }

    public OrderDetailDto(int id, ClothesDto clothes, int quantity, OrderDto order) {
        this.id = id;
        this.clothes = clothes;
        this.quantity = quantity;
        this.order = order;
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
     * @return the clothes
     */
    public ClothesDto getClothes() {
        return clothes;
    }

    /**
     * @param clothes the clothes to set
     */
    public void setClothes(ClothesDto clothes) {
        this.clothes = clothes;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the order
     */
    public OrderDto getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(OrderDto order) {
        this.order = order;
    }
    
}
