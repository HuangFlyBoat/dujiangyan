package com.dujiangyan.tour_server.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class ProductDetail {

    private int id;

    private String name;

    private String img;

    private BigDecimal price;

    private String detailImg;

    List<SpeDTO> speList;
}
