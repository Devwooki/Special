package com.ssafy.special.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class RecipeReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long reviewId;

    @Column(nullable = false, columnDefinition = "varchar(200)")
    String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;
}
