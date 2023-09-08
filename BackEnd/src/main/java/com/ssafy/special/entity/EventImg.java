package com.ssafy.special.entity;

import javax.persistence.*;

@Entity
public class EventImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long eventImgId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    Event event;

    @Lob
    String eventImg;
}
