/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services;

import com.team.fashionStore.payloads.CategoryDto;
import com.team.fashionStore.pojo.Category;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface CategoryService {
    CategoryDto createCategory(CategoryDto c);
    CategoryDto updateCategory(CategoryDto c,Integer id);
    CategoryDto getCategoryById(Integer id);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Integer id);
}
