package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "spe")
public class Spe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speId")
    private long speId;

    @Column(name = "name")
    private String name;

    @Column(name = "productId")
    private long productId;
}
