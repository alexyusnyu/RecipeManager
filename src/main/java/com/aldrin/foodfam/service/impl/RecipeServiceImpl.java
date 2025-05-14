/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.foodfam.service.impl;

import com.aldrin.foodfam.model.Recipe;
import com.aldrin.foodfam.repository.RecipeRepository;
import com.aldrin.foodfam.service.RecipeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author ALDRIN
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    //sorting
    @Override
    public List<Recipe> getTitleSortByKeyword(String keyword) {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        return recipeRepository.findByTitleContaining(keyword, sort);

    }

    @Override
    public Recipe findById(Integer id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return recipe.get();
        }
        throw new RuntimeException("Recipe is not found for the id" + id);
    }

    public Page<Recipe> listAll(int pageNumber, String sortField, String sortDir, String recipe) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 10, sort);
        if (recipe != null) {
            return recipeRepository.findAll(recipe, pageable);
        }
        return recipeRepository.findAll(pageable);
    }
}
