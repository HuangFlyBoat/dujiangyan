package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.domain.LoginInfo;
import com.dujiangyan.tour_server.entity.Cart;
import com.dujiangyan.tour_server.entity.User;
import com.dujiangyan.tour_server.repository.CartRepository;
import com.dujiangyan.tour_server.service.CartService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private  CartRepository cartRepository;


    @Override
    public List<CartInfo> getCartList(HttpServletRequest request) {
        LoginInfo userInfo = (LoginInfo) request.getSession().getAttribute("login");

        List<CartInfo> cartList = cartRepository.getCartList(userInfo.getId());
        return cartList;
    }

    // 在这里实现 CartService 接口中定义的方法
}
