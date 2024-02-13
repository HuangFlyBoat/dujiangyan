package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.ProductRepository;
import com.dujiangyan.tour_server.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 在这里实现 ProductService 接口中定义的方法
}
