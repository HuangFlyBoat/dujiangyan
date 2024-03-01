package com.dujiangyan.tour_server.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private String img;
    private BigDecimal price;
    private String detailImg;

    // getters and setters
}