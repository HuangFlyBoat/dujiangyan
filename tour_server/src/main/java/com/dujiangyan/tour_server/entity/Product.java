package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "Img")
    private String img;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "detailImg")
    private String detailImg;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;


}
