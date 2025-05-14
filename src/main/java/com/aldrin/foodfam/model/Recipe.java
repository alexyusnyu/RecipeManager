package com.aldrin.foodfam.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Recipe extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String image;
    @Column(length = 600)
    private String description;
    @Column(length = 600)
    private String information;

    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = Instruction.class)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<Instruction> instruction;

    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = Ingredient.class)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<Ingredient> ingredient;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = MarketingGuide.class)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<MarketingGuide> marketingGuide;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = Note.class)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<Note> note;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = YieldPerVolume.class)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<YieldPerVolume> yieldPerVolume;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, targetEntity = Nutrition.class)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private List<Nutrition> nutrition;
    

}
