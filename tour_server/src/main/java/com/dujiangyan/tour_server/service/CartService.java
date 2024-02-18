package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.entity.Cart;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CartService {

    List<CartInfo> getCartList(HttpServletRequest request);

    int update(HttpServletRequest request, Cart cart, Integer SpeId, Integer productId);

}
