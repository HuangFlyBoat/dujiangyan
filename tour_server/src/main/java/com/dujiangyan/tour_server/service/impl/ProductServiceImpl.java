package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.ProductDetail;
import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.entity.Spe;
import com.dujiangyan.tour_server.repository.ProductRepository;
import com.dujiangyan.tour_server.repository.SpeRepository;
import com.dujiangyan.tour_server.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;

    @Resource
    private SpeRepository speRepository;


    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public ProductDetail findById(int id) {
        ProductDetail productDetail = new ProductDetail();
        Product product = productRepository.findById(id).orElse(null);
        List<Spe> speList = speRepository.findAllByProductId(id);
        if (product != null) {
            productDetail.setId(product.getId());
            productDetail.setName(product.getName());
            productDetail.setImg(product.getImg());
            productDetail.setPrice(product.getPrice());
            productDetail.setDetailImg(product.getDetailImg());
            productDetail.setSpeList(speList);
        }

        return productDetail;
    }

}
