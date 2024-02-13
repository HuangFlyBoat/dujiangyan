package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.repository.OrderRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 添加其他方法，处理订单相关的请求和操作
    // 可以根据需求自行定义接口
}
