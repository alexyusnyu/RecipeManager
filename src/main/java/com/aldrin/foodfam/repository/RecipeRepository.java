package com.aldrin.foodfam.repository;

import com.aldrin.foodfam.model.Recipe;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByDescriptionContaining(String keyword);

    List<Recipe> findByTitleContaining(String keyword, Sort sort);

    Page<Recipe> findByTitleContaining(String keyword, Pageable pageable);

    List<Recipe> findByTitleContaining(String search);

    @Query("SELECT p FROM Recipe p WHERE p.title LIKE %?1%")
    public Page<Recipe> findAll(String keyword, Pageable pageable);

    List<Recipe> findByTitle(String title);

}
