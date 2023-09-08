package com.ssafy.special.entity;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(nullable = false)
    String recipeName;

    @Column(nullable = false)
    String recipeSimple;

    @Lob
    @Column(nullable = false)
    String recipeDesc;

    @ColumnDefault("0")
    Long views;

    @ColumnDefault("0")
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
