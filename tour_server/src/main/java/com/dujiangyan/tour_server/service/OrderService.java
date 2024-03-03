package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findByUserId(int userId);


    Order createOrderFromCartInfo(List<CartInfo> cartInfos, Integer userId, Integer addressId);

}
