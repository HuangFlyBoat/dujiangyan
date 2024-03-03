package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.entity.Detail;
import com.dujiangyan.tour_server.entity.Order;
import com.dujiangyan.tour_server.repository.CartRepository;
import com.dujiangyan.tour_server.repository.DetailRepository;
import com.dujiangyan.tour_server.repository.OrderRepository;
import com.dujiangyan.tour_server.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CartRepository cartRepository;


    @Resource
    private DetailRepository detailRepository;


    @Override
    public List<Order> findByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }


    @Override
    @Transactional
    public Order createOrderFromCartInfo(List<CartInfo> cartInfos, Integer userId, Integer addressId) {
        // 1. 计算总金额
        BigDecimal total = cartInfos.stream()
                .map(cartInfo -> cartInfo.getProductPrice().multiply(new BigDecimal(cartInfo.getNumber())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 2. 创建订单
        Order order = new Order();
        order.setUserId(userId);
        order.setAddressId(addressId);
        order.setTotal(total);
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        order.setDate(formattedDateTime);
        order = orderRepository.save(order);

        // 3. 创建订单详情
        for (CartInfo cartInfo : cartInfos) {
            Detail detail = new Detail();
            detail.setOrderId(order.getId());
            detail.setProductId(cartInfo.getProductId());
            detail.setNumber(cartInfo.getNumber());
            detail.setSpeId(cartInfo.getSpeId());
            detailRepository.save(detail);
        }

        // 4. 删除对应的购物车条目
        List<Integer> cartIds = cartInfos.stream()
                .map(CartInfo::getCartId)
                .collect(Collectors.toList());
        cartRepository.deleteByIdIn(cartIds);


        return order;
    }
}
