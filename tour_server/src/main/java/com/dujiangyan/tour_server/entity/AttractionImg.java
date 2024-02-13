package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attractionImg")
public class AttractionImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "attractionId")
    private long attractionId;
}
