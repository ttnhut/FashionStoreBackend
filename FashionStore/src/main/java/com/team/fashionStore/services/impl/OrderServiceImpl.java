/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services.impl;

import com.team.fashionStore.exceptions.ResourceNotFoundException;
import com.team.fashionStore.payloads.OrderDto;
import com.team.fashionStore.pojo.Order;
import com.team.fashionStore.pojo.User;
import com.team.fashionStore.repositories.OrderRepository;
import com.team.fashionStore.repositories.UserRepository;
import com.team.fashionStore.services.OrderService;
import java.util.Date;
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
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    
     @Override
    public OrderDto createOrder(Integer id) {
        User u = this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
        Order o = new Order();
        o.setUser(u);
        o.setCreatedDate(new Date());
        return this.modelMapper.map(this.orderRepository.save(o), OrderDto.class);
        
    }
    

    @Override
    public void deleteOrder(Integer id) {
        Order o = this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","id", id));
        this.orderRepository.delete(o);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> list = this.orderRepository.findAll();
        return list.stream().map(item->this.modelMapper.map(item, OrderDto.class)).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Integer id) {
        Order o = this.orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order","id", id));
        return this.modelMapper.map(o, OrderDto.class);
    }

   
    
}
