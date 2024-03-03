package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.domain.ProductAddRequest;
import com.dujiangyan.tour_server.domain.ProductDTO;
import com.dujiangyan.tour_server.domain.ProductDetail;
import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Resource
    ProductService productService;

    @GetMapping("/getProductList")
    public BaseResponse<List<ProductDTO>> getProductList() {
        return ResultUtils.success(productService.getProductList());
    }


    @GetMapping("/getDetail")
    public BaseResponse<ProductDetail> getDetail(@RequestParam int id) {
        return ResultUtils.success(productService.findById(id));
    }

    @PostMapping("/addProduct")
    public BaseResponse addProduct(@RequestBody ProductAddRequest productAddRequest) {
        int result = productService.addProductWithSpe(productAddRequest);
        if (result == -1) {
            return ResultUtils.error(ErrorCode.EDIT_ERROR);
        }
        return ResultUtils.success(result);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/delete")
    public BaseResponse deleteProduct(@RequestBody Product product) {
        int result = productService.deleteProductAndSpe(product.getId());
        if (result == -1) {
            return ResultUtils.error(ErrorCode.EDIT_ERROR);
        } else {
            return ResultUtils.success(ErrorCode.SUCCESS);
        }
    }

    @PostMapping("/edit")
    public BaseResponse editProduct(@RequestBody Product product) {
        ProductDTO product1 = productService.editProductWithSpe(product);
        if (product1 == null) {
            return ResultUtils.error(ErrorCode.EDIT_ERROR);
        } else {
            return ResultUtils.success(product1);
        }

    }



}
