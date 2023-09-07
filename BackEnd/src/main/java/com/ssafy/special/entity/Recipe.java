package com.ssafy.special.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long recipeId;

    @ManyToOne
    @JoinColumn(name="writer_id")
    User writer;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    String recipeName;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    String recipeSimple;

    @Lob
    @Column(nullable = false)
    String recipeDesc;

    @Column(nullable = false, columnDefinition = "default 0")
    Long views;

    @Column(nullable = false, columnDefinition = "default 0")
    Long likes;

    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted;

    @Lob
    String recipeViedoUrl;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime updatedAt;



}
