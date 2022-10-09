/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services;

import com.team.fashionStore.payloads.UserDto;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface UserService {
    UserDto registerNewUser(UserDto user);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer id);
    void deleteUser(Integer id);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUsers();
    
    
}
