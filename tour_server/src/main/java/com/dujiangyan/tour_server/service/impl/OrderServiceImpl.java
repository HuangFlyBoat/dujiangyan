package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.OrderRepository;
import com.dujiangyan.tour_server.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 在这里实现 OrderService 接口中定义的方法
}
