package com.dujiangyan.tour_server.domain;

import com.dujiangyan.tour_server.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductAddRequest extends Product {

    private List<String> speName;

}
