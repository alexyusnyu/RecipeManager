package com.aldrin.foodfam.repository;

import com.aldrin.foodfam.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
