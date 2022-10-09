/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.repositories;

import com.team.fashionStore.pojo.Category;
import com.team.fashionStore.pojo.Clothes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Asus
 */
public interface ClothesRepository extends JpaRepository<Clothes, Integer> {
    List<Clothes> findByCategory(Category category);
    
    @Query("select c from Clothes c where lower(c.name) like concat('%', :keyword,'%')")
    List<Clothes> searchByName(@Param("keyword") String kw);
}
