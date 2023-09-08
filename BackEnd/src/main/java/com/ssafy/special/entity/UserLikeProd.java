package com.ssafy.special.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserLikeProd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_like_prod_id")
    Long UserLikeProdId;

    //외래키를 가지는 테이블은 UserLikeProd이므로 연관관계의 주인이 된다.
    //유저는 여러 개의 상품을 관심 상품으로 등록할 수 있다(유저 : 상품 = 1 : N)

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @ManyToOne
    @JoinColumn(name="product_id")
    Product product;

    @Column(nullable = false)
    boolean likeEmailRecevie;

    @Column(nullable = false)
    boolean likeStat;

}
