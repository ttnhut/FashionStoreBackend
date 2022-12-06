/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.controllers;

import com.team.fashionStore.services.ClothesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/v1")
public class StatisticController {
    @Autowired
    private ClothesService clothesService;
    @GetMapping("/statistics/clothes")
    public ResponseEntity<List<Object>> countClothesByCategory(){
        return ResponseEntity.ok(this.clothesService.countClothesByCategory());
    }
}
