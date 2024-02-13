package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "productId")
    private String productId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "number")
    private int number;

    @Column(name = "speId")
    private String speId;
}
