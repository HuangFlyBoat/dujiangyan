package com.dujiangyan.tour_server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attractionImg")
public class AttractionImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "imgUrl")
    private String imgUrl;

    @ManyToOne
    @JsonBackReference

    @JoinColumn(name = "attractionId")
    private Attraction attraction;
}