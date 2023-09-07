package com.ssafy.special.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id")
    Long productId;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    String producetName;

    @Column(nullable = false)
    @Lob
    String productImg;

    @Column(nullable = false, columnDefinition = "int default 0")
    Long price;

    @Column(nullable = false)
    @Lob
    String productDesc;

    @Column(nullable = false)
    String eigen;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime updatedAt;

}
