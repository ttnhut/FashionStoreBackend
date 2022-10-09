/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.exceptions;

/**
 *
 * @author Asus
 */
public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }

    public ApiException() {
        super();
    }
    
}
