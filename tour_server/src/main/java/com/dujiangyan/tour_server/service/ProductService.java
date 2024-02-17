package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.domain.ProductDetail;
import com.dujiangyan.tour_server.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
    /**
     * 获取土特产列表
     **/
    List<Product> getProductList();

    /**
     * 根据id获取土特产
     **/
    ProductDetail findById(int id);
}
