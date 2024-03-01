package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "spe")
public class Spe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speId")
    private int speId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "spe")
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;



    // getters and setters
}
