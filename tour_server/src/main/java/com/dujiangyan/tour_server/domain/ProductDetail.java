package com.dujiangyan.tour_server.domain;

import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.entity.Spe;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDetail extends Product {

    List<Spe> speList;
}
