package com.dujiangyan.tour_server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor  // 自动生成无参构造器
@AllArgsConstructor // 自动生成全参构造器
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

}
