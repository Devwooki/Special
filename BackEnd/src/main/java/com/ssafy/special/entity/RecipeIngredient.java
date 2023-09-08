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

    @ManyToOne
    @JoinColumn(name = "product_id") // 재료 테이블과 연결하는 컬럼
    Product product;

    @Column
    Long ingredientSeq;
}
