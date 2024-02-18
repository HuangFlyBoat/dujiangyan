package com.dujiangyan.tour_server.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartInfo {
    private Integer cartId;
    private Integer userId;
    private Integer number;
    private Integer productId;
    private String productName;
    private String productImg;
    private BigDecimal productPrice;
    private String productDetailImg;
    private Integer speId;
    private String speName;

    public CartInfo(Integer cartId, Integer userId, Integer number, Integer productId, String productName, String productImg, BigDecimal productPrice, String productDetailImg, Integer speId, String speName) {
        this.cartId = cartId;
        this.userId = userId;
        this.number = number;
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productDetailImg = productDetailImg;
        this.speId = speId;
        this.speName = speName;
    }
}
