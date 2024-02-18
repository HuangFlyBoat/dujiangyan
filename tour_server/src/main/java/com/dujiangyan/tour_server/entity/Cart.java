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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "speId")
    private Spe spe;


}
