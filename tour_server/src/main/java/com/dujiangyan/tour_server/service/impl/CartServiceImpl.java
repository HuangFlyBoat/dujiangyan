package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.CartRepository;
import com.dujiangyan.tour_server.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // 在这里实现 CartService 接口中定义的方法
}
