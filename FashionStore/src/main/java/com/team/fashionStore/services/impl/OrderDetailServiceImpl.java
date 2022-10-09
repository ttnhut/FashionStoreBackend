/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services.impl;

import com.team.fashionStore.exceptions.ResourceNotFoundException;
import com.team.fashionStore.payloads.OrderDetailDto;
import com.team.fashionStore.pojo.Clothes;
import com.team.fashionStore.pojo.Order;
import com.team.fashionStore.pojo.OrderDetail;
import com.team.fashionStore.repositories.ClothesRepository;
import com.team.fashionStore.repositories.OrderDetailRepository;
import com.team.fashionStore.repositories.OrderRepository;
import com.team.fashionStore.services.OrderDetailService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClothesRepository clothesRepository;
    
    @Override
    public OrderDetailDto createOrderDetail(Integer orderId, Integer clothesId, OrderDetailDto order) {
        Order o = this.orderRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order", "id", orderId));
        Clothes c = this.clothesRepository.findById(clothesId).orElseThrow(()->new ResourceNotFoundException("Clothes", "id", clothesId));
        OrderDetail or = this.modelMapper.map(order, OrderDetail.class);
        or.setOrder(o);
        or.setClothes(c);
       
        return this.modelMapper.map(this.orderDetailRepository.save(or), OrderDetailDto.class);
    }

    @Override
    public OrderDetailDto updateOrderDetail(OrderDetailDto order, Integer id) {
        OrderDetail o = this.orderDetailRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("OrderDetail", "id", id));
        o.setQuantity(order.getQuantity());
        return this.modelMapper.map(this.orderDetailRepository.save(o), OrderDetailDto.class);
    }

    @Override
    public void deleteOrderDetail(Integer id) {
       OrderDetail o = this.orderDetailRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("OrderDetail", "id", id));
       this.orderDetailRepository.delete(o);
     }

    @Override
    public List<OrderDetailDto> getOrderDetailByOrder(Integer id) {
         Order o = this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order", "id", id));
         List<OrderDetail> list = this.orderDetailRepository.findByOrder(o);
         return list.stream().map(item->this.modelMapper.map(item, OrderDetailDto.class)).collect(Collectors.toList());
     }

    
}
