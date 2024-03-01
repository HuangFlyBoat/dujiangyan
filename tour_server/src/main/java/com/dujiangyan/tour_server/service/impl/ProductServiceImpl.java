package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.ProductAddRequest;
import com.dujiangyan.tour_server.domain.ProductDetail;
import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.entity.Spe;
import com.dujiangyan.tour_server.service.ProductService;
import com.dujiangyan.tour_server.service.repository.ProductRepository;
import com.dujiangyan.tour_server.service.repository.SpeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @Transactional
    public int addProductWithSpe(ProductAddRequest productAddRequest) {
        List<String> speNames = productAddRequest.getSpeName();
        Product product = new Product();
        product.setName(productAddRequest.getName());
        if (speNames != null && !speNames.isEmpty()) {
            List<Spe> speList = new ArrayList<>();
            for (String speName : speNames) {
                Spe spe = new Spe();
                spe.setName(speName);
                spe.setProduct(product);
                speList.add(spe);
            }
            product.setSpeList(speList);
        }
        return productRepository.save(product).getId();
    }

    @Transactional
    @Override
    public int deleteProductAndSpe(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
            if (productRepository.findById(productId).isEmpty()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
