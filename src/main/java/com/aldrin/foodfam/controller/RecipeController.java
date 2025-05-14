/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.foodfam.controller;

import com.aldrin.foodfam.model.Recipe;
import com.aldrin.foodfam.repository.RecipeRepository;
import com.aldrin.foodfam.service.impl.RecipeServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ALDRIN
 */
@Controller
@RequestMapping("/")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository studentRepository) {
        this.recipeRepository = studentRepository;
    }

    @Autowired
    public RecipeServiceImpl recipeImp;

    @RequestMapping("/")
    public String viewIndexPage( Model model, @Param("recipe") String recipe) {
        return viewPage(model, 1, "title", "asc", recipe);
    }

    @RequestMapping("/page/{pageNum}")
    public String viewPage( Model model,
            @PathVariable("pageNum") int pageNum,
            @Param("sortField") String sortField,
            @Param("sortDir") String sortDir,
            @Param("recipe") String recipe) {

        Page<Recipe> page = recipeImp.listAll(pageNum, sortField, sortDir, recipe);
        List<Recipe> listProducts = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("recipes", listProducts);
        model.addAttribute("recipe", recipe);

        return "index";
    }

    @RequestMapping("/recipeDetails/{title}")
    public String recipeDetails(@PathVariable String title, Model model) {
        List<Recipe> recipe = recipeRepository.findByTitle(title);
        model.addAttribute("recipes", recipe);
        return "recipe_details";
    }

}
