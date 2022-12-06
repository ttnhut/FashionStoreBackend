/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.services.impl;

import com.team.fashionStore.exceptions.ResourceNotFoundException;
import com.team.fashionStore.payloads.ClothesDto;
import com.team.fashionStore.payloads.ClothesResponse;
import com.team.fashionStore.pojo.Category;
import com.team.fashionStore.pojo.Clothes;
import com.team.fashionStore.repositories.CategoryRepository;
import com.team.fashionStore.repositories.ClothesRepository;
import com.team.fashionStore.services.ClothesService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class ClothesServiceImpl implements ClothesService{
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    
    
    @Override
    public ClothesDto createClothes(ClothesDto clothes, Integer id) {
        Category cat = this.categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
        Clothes c = this.modelMapper.map(clothes, Clothes.class);
        c.setCategory(cat);
        return this.modelMapper.map(this.clothesRepository.save(c), ClothesDto.class);
    }

    @Override
    public ClothesDto updateClothes(ClothesDto clothes, Integer Id) {
        Clothes c = this.clothesRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Clothes", "id", Id));
        c.setColor(clothes.getColor());
        c.setDescription(clothes.getDescription());
        c.setImage(clothes.getImage());
        c.setName(clothes.getName());
        c.setQuantity(clothes.getQuantity());
        c.setCategory(this.modelMapper.map(clothes.getCategory(), Category.class));
        return this.modelMapper.map(this.clothesRepository.save(c), ClothesDto.class);
    }

    @Override
    public void deleteClothes(Integer id) {
          Clothes c = this.clothesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Clothes", "id", id));
          this.clothesRepository.delete(c);
         
     }

    @Override
    public ClothesResponse getAllClothes(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort= Sort.by(sortBy).ascending();
        }else{
            sort= Sort.by(sortBy).descending();
        }
        Pageable p = PageRequest.of(pageNumber, pageSize, sort);
        Page<Clothes> page = this.clothesRepository.findAll(p);
        List<Clothes> list = page.getContent();
        ClothesResponse res = new ClothesResponse();
        res.setContent(list.stream().map(item->this.modelMapper.map(item, ClothesDto.class)).collect(Collectors.toList()));
        res.setPageNumber(page.getNumber());
        res.setPageSize(page.getSize());
        res.setTotalElements(page.getTotalElements());
        res.setTotalPages(page.getTotalPages());
        res.setLastPage(page.isLast());
        return res;
    }

    @Override
    public ClothesDto getClothesByid(Integer id) {
        Clothes c = this.clothesRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Clothes", "id", id));
        return this.modelMapper.map(c, ClothesDto.class);
     }
    

    @Override
    public List<ClothesDto> getClothesByCategory(Integer id) {
        Category c = this.categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "id", id));
        List<Clothes> list = this.clothesRepository.findByCategory(c);
        return list.stream().map(item->this.modelMapper.map(item, ClothesDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ClothesDto> searchClothes(String keyword) {
        System.out.println(keyword);
        List<Clothes> list = this.clothesRepository.searchByName(keyword);
        return list.stream().map(item->this.modelMapper.map(item,ClothesDto.class)).collect(Collectors.toList());
     }

    @Override
    public List<Object> countClothesByCategory() {
        
        return this.clothesRepository.countClothesByCategory();
      }
  
}
