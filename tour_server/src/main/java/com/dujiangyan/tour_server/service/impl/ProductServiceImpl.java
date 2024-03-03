package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.ProductAddRequest;
import com.dujiangyan.tour_server.domain.ProductDTO;
import com.dujiangyan.tour_server.domain.ProductDetail;
import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.entity.Spe;
import com.dujiangyan.tour_server.service.ProductService;
import com.dujiangyan.tour_server.repository.ProductRepository;
import com.dujiangyan.tour_server.repository.SpeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;

    @Resource
    private SpeRepository speRepository;


    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO> getProductList() {
        // 查询所有产品
        List<Product> products = productRepository.findAll();

        // 将Product实体转换为ProductDTO
        return products.stream().map(product -> {
            ProductDTO dto = new ProductDTO();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setImg(product.getImg());
            dto.setPrice(product.getPrice());
            dto.setDetailImg(product.getDetailImg());
            // 根据需要添加更多字段的映射
            return dto;
        }).collect(Collectors.toList());
    }

    public ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setImg(product.getImg());
        dto.setPrice(product.getPrice());
        dto.setDetailImg(product.getDetailImg());
        return dto;
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
        product.setImg(productAddRequest.getImg());
        product.setPrice(productAddRequest.getPrice());
        product.setDetailImg(productAddRequest.getDetailImg());
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

        @Override
        @Transactional
        public ProductDTO editProductWithSpe(Product newProduct) {
            Optional<Product> oldProductOpt = productRepository.findById(newProduct.getId());

            if (oldProductOpt.isPresent()) {
                Product oldProduct = oldProductOpt.get();

                if (newProduct.getName() != null) {
                    oldProduct.setName(newProduct.getName());
                }

                if (newProduct.getImg() != null) {
                    oldProduct.setImg(newProduct.getImg());
                }

                if (newProduct.getPrice() != null) {
                    oldProduct.setPrice(newProduct.getPrice());
                }

                if (newProduct.getDetailImg() != null) {
                    oldProduct.setDetailImg(newProduct.getDetailImg());
                }

                // 在这里添加其他字段的检查和更新

                return convertToDTO(productRepository.save(oldProduct));
            } else {
                return null;
            }
        }
        }

