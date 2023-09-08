package com.ssafy.special.entity;

import com.ssafy.special.enums.SocialType;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(nullable = false)
    String nickname;

    @Column(name="user_img")
    @Lob
    String userImg;

    @Enumerated(EnumType.STRING)
    SocialType social;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    String email;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime updatedAt;

    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean mailReceive;

    @OneToMany(mappedBy = "user")
    private Set<UserLikeProd> likeProducts = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private List<UserLikeRecipe> likeRecipes = new LinkedList<>();

    @OneToMany(mappedBy = "writer")
    private List<Recipe> writeRecipes = new LinkedList<>();
}
