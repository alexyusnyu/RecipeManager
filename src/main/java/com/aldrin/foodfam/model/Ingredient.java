/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.foodfam.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
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
public class Ingredient extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ingredient;
 
    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = Serving25.class)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private List<Serving25> serving25;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = Serving50.class)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private List<Serving50> serving50;
    
    
}
