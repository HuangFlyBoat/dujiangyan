package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.domain.ProductAddRequest;
import com.dujiangyan.tour_server.domain.ProductDTO;
import com.dujiangyan.tour_server.domain.ProductDetail;
import com.dujiangyan.tour_server.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * 获取土特产列表
     **/
    List<ProductDTO> getProductList();

    /**
     * 根据id获取土特产
     **/
    ProductDetail findById(int id);


    /**
     * @param productAddRequest 添加的土特产信息
     * @return 返回-1表示添加失败
     */
    int addProductWithSpe(ProductAddRequest productAddRequest);

    /**
     * 删除土特产
     * @param productId 土特产id
     */
    int deleteProductAndSpe(int productId);


    /**
     * 编辑土特产
     * @param product 土特产信息
     */
    ProductDTO editProductWithSpe(Product product);
}
