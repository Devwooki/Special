package com.ssafy.special.entity;

import com.ssafy.special.enums.EventType;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

public class EventProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventProductId;

    @OneToMany
    Product product;

    @Enumerated(EnumType.STRING)
    EventType eventType;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime startDate;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime endDate;

    @ColumnDefault("false")
    boolean isSaled;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime updatedAt;



}
