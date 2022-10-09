/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services.impl;

import com.team.fashionStore.configs.AppConstants;
import com.team.fashionStore.exceptions.ResourceNotFoundException;
import com.team.fashionStore.payloads.UserDto;
import com.team.fashionStore.pojo.Role;
import com.team.fashionStore.pojo.User;
import com.team.fashionStore.repositories.RoleRepository;
import com.team.fashionStore.repositories.UserRepository;
import com.team.fashionStore.services.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public UserDto createUser(UserDto user) {
        User u = this.modelMapper.map(user, User.class);
        return this.modelMapper.map(this.userRepository.save(u), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer id) {
        User u = this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
        u.setPassword(user.getPassword());
        return this.modelMapper.map(this.userRepository.save(u), UserDto.class);
    }

    @Override
    public void deleteUser(Integer id) {
        User u = this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
        this.userRepository.delete(u);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return this.modelMapper.map(this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id)), UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> list = this.userRepository.findAll();
        return list.stream().map(item->this.modelMapper.map(item, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto registerNewUser(UserDto user) {
        User u = this.modelMapper.map(user, User.class);
        u.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();
        u.getRoles().add(role);
        return this.modelMapper.map(this.userRepository.save(u), UserDto.class);
   }
    
}
