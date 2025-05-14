/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.foodfam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ALDRIN
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Nutrition extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String amountPerServing;
    private Integer calories;
    private String totalFat;
    private String saturatedFat;
    private String cholesterol;
    private String sodium;
    private String potassium;
    private String totalCarbohydrates;
    private String dietaryFiber;
    private String totalSugars;
    private String protein;
    private String vitaminC;
    private String vitaminD;
    private String calcium;
    private String iron;
    private String vitaminA;
    
}
