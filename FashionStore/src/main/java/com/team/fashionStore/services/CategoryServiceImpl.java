/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services;

import com.team.fashionStore.exceptions.ResourceNotFoundException;
import com.team.fashionStore.payloads.CategoryDto;
import com.team.fashionStore.pojo.Category;
import com.team.fashionStore.repositories.CategoryRepository;
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
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public CategoryDto createCategory(CategoryDto c) {
        Category cat = this.modelMapper.map(c, Category.class);
        System.out.println();
        return this.modelMapper.map(this.categoryRepository.save(cat),CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto c, Integer id) {
        Category cat = this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id));
        cat.setName(c.getName());
        return this.modelMapper.map(this.categoryRepository.save(cat), CategoryDto.class);
     }

    @Override
    public CategoryDto getCategoryById(Integer id) {
        
        return this.modelMapper.map(this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id)), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> listCat = this.categoryRepository.findAll();
        return listCat.stream().map(item->this.modelMapper.map(item, CategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer id) {
        Category cat = this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id));
        this.categoryRepository.delete(cat);
    }
    
}
