/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.controllers;

import com.team.fashionStore.configs.AppConstants;
import com.team.fashionStore.payloads.ApiResponse;
import com.team.fashionStore.payloads.ClothesDto;
import com.team.fashionStore.payloads.ClothesResponse;
import com.team.fashionStore.services.ClothesService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/v1/")
public class ClothesController {
    @Autowired
    private ClothesService clothesService;
    
    @PostMapping("/categories/{id}/clothes")
    public ResponseEntity<ClothesDto> createClothes(@PathVariable(value = "id") Integer id ,@Valid @RequestBody ClothesDto clothes){
        return new ResponseEntity<>(this.clothesService.createClothes(clothes, id),HttpStatus.CREATED);
    }
    
    @GetMapping("/categories/{id}/clothes")
    public ResponseEntity<List<ClothesDto>> getClothesByCategory(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(this.clothesService.getClothesByCategory(id));
    }
    
    @GetMapping("/clothes")
    public ResponseEntity<ClothesResponse> getAllClothes(@RequestParam(value = "pageNumber", required = false, defaultValue = AppConstants.PAGE_NUMBER) Integer pageNumber,
            @RequestParam(value = "pageSize",required = false,defaultValue = AppConstants.PAGE_SIZE) Integer pageSize,
            @RequestParam(value = "sortBy",required = false,defaultValue = AppConstants.SORT_BY) String sortBy,
            @RequestParam(value = "sortDir",required = false,defaultValue = AppConstants.SORT_DIR) String sortDir){
        return ResponseEntity.ok(this.clothesService.getAllClothes(pageNumber,pageSize,sortBy,sortDir));
    }
    
    @GetMapping("/clothes/{id}")
    public ResponseEntity<ClothesDto> getSingleClothes(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(this.clothesService.getClothesByid(id));
    }
    
    @DeleteMapping("/clothes/{id}")
    public ResponseEntity<ApiResponse> deleteClothes(@PathVariable(value = "id") Integer id){
        this.clothesService.deleteClothes(id);
        return ResponseEntity.ok(new ApiResponse("Clothes is deleted successfully", true));
    }
    @PutMapping("/clothes/{id}")
    public ResponseEntity<ClothesDto> updateClothes(@PathVariable(value = "id") Integer id, @Valid @RequestBody ClothesDto clothes){
        return ResponseEntity.ok(this.clothesService.updateClothes(clothes, id));
    }
    
    @GetMapping("/clothes/search/{keywords}")
    public ResponseEntity<List<ClothesDto>> searchClothesByName(@PathVariable(value = "keywords") String keywords){
        return ResponseEntity.ok(this.clothesService.searchClothes(keywords));
    }
}
