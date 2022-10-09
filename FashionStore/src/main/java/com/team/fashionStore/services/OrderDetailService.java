/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services;

import com.team.fashionStore.payloads.OrderDetailDto;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface OrderDetailService {
    OrderDetailDto createOrderDetail(Integer orderId, Integer clothesId, OrderDetailDto order);
    OrderDetailDto updateOrderDetail(OrderDetailDto order, Integer id);
    void deleteOrderDetail(Integer id);
    List<OrderDetailDto> getOrderDetailByOrder(Integer id);
}
