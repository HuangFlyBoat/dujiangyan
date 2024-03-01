package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.entity.Order;
import com.dujiangyan.tour_server.service.repository.OrderRepository;
import com.dujiangyan.tour_server.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;


    @Override
    public List<Order> findByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }
}
