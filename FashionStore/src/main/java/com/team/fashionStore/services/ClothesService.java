/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services;

import com.team.fashionStore.payloads.ClothesDto;
import com.team.fashionStore.payloads.ClothesResponse;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ClothesService {
    ClothesDto createClothes(ClothesDto clothes, Integer id);
    ClothesDto updateClothes(ClothesDto clothes, Integer Id);
    void deleteClothes(Integer id);
    ClothesResponse getAllClothes(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    ClothesDto getClothesByid(Integer id);
    List<ClothesDto> getClothesByCategory(Integer id);
    List<ClothesDto> searchClothes(String keyword);
}

