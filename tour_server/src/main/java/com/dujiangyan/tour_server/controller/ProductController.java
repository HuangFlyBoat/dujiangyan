package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.domain.ProductDetail;
import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Resource
    ProductService productService;

    @GetMapping("/getProductList")
    public BaseResponse<List<Product>> getProductList() {
        return ResultUtils.success(productService.getProductList());
    }


    @GetMapping("/getDetail")
    public BaseResponse<ProductDetail> getDetail(@RequestParam int id) {
        return ResultUtils.success(productService.findById(id));
    }

}
