package com.ssafy.special.entity;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class UserLikeRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long likeRecipeId;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;
    @ManyToOne
    @JoinColumn(name="recipe_id")
    Recipe recipe;

    @ColumnDefault("false")
    boolean isDeleted;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime updatedAt;
}
