package com.dujiangyan.tour_server.domain;

import lombok.Data;

import java.util.List;
@Data
public class CartInfoRequest {
    private List<CartInfo> cartInfos;

}
