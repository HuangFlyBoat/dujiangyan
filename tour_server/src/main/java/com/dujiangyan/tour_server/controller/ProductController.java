package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 添加其他方法，处理产品相关的请求和操作
    // 可以根据需求自行定义接口
}
