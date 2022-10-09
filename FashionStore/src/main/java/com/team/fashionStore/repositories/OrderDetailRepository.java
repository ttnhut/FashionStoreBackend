/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.repositories;

import com.team.fashionStore.pojo.Order;
import com.team.fashionStore.pojo.OrderDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Asus
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
    List<OrderDetail> findByOrder(Order order);
}
