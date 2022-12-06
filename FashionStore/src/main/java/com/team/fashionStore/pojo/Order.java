/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "created_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;
    public Order() {
    }

    public Order(int id, Date createdDate, User user, Set<OrderDetail> orderDetails) {
        this.id = id;
        this.createdDate = createdDate;
        this.user = user;
        this.orderDetails = orderDetails;
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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the orderDetails
     */
    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * @param orderDetails the orderDetails to set
     */
    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    
    
}
