package com.ssafy.special.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class RecipeIngredient {
    @Id
    @GeneratedValue
    Long recipeIngredientId;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;


    //Product product;

    @Column
    Long ingredientSeq;
}
