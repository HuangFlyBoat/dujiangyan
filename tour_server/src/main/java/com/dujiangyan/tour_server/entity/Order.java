package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "`order`")  // 注意，order是SQL的关键字，因此需要用反引号（`）包围起来
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "date")
    private String date;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "addressId")
    private int addressId;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detail> details = new ArrayList<>();
}
