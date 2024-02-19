package com.dujiangyan.tour_server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "attraction")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "level")
    private String level;

    @Column(name = "address")
    private String address;

    @Column(name = "businessHours")
    private String businessHours;

    @Column(name = "ticketPrice")
    private BigDecimal ticketPrice;

    @Column(name = "introduced")
    private String introduced;

    @OneToMany(mappedBy = "attraction")
    @JsonManagedReference
    private List<AttractionImg> images;
}
