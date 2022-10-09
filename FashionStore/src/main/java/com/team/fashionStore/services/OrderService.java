/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services;

import com.team.fashionStore.payloads.OrderDto;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface OrderService {
    OrderDto createOrder( Integer id);
    void deleteOrder(Integer id);
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(Integer id);
}
