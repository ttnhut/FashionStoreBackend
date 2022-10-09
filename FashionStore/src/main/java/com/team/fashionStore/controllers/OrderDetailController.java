/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.controllers;

import com.team.fashionStore.payloads.ApiResponse;
import com.team.fashionStore.payloads.OrderDetailDto;
import com.team.fashionStore.services.OrderDetailService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/v1/")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;
    
    
    @PostMapping("/orders/{orderId}/clothes/{clothesId}/orderdetails")
    public ResponseEntity<OrderDetailDto> createOrderDetail( @RequestBody OrderDetailDto order,
            @PathVariable(value = "orderId") Integer orderId, 
            @PathVariable(value = "clothesId") Integer clothesId){
        return new ResponseEntity<>(this.orderDetailService.createOrderDetail(orderId, clothesId, order),HttpStatus.CREATED);
    }
    
    @PutMapping("/orderdetails/{id}")
    public ResponseEntity<OrderDetailDto> updateOrderDetail(@PathVariable(value = "id") Integer id, @Valid @RequestBody OrderDetailDto order){
        return ResponseEntity.ok(this.orderDetailService.updateOrderDetail(order, id));
    }
    
    @DeleteMapping("/orderdetails/{id}")
    public ResponseEntity<ApiResponse> deleteOrderDetail(@PathVariable(value = "id") Integer id){
        this.orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.ok(new ApiResponse("OrderDetail deleted successfully", true));
    }
    
    @GetMapping("/orders/{id}/orderdetails")
    public ResponseEntity<List<OrderDetailDto>> getOrderDetailsByOrder(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(this.orderDetailService.getOrderDetailByOrder(id));
    }
    
}
