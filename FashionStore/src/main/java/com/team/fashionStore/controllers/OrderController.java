/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.controllers;

import com.team.fashionStore.payloads.ApiResponse;
import com.team.fashionStore.payloads.OrderDto;
import com.team.fashionStore.services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/v1/")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/users/{id}/orders")
    public ResponseEntity<OrderDto> createOrder(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(this.orderService.createOrder(id),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable(value = "id") Integer id){
        this.orderService.deleteOrder(id);
        return ResponseEntity.ok(new ApiResponse("Order deleted successfully", true));
    }
    
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(this.orderService.getAllOrders());
    }
    
    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDto> getSingleOrders(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(this.orderService.getOrderById(id));
    }
}
