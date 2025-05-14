/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.foodfam.repository;

import com.aldrin.foodfam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ALDRIN
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
