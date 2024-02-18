package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "orderId")
    private int orderId;

    @Column(name = "productId")
    private int productId;

    @Column(name = "number")
    private int number;
}
