package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.domain.LoginInfo;
import com.dujiangyan.tour_server.entity.Order;
import com.dujiangyan.tour_server.service.OrderService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/getOrderLIst")
    public BaseResponse<List<Order>> getOrderList(HttpServletRequest request) {
        LoginInfo userInfo = (LoginInfo) request.getSession().getAttribute("login");
        int userId = userInfo.getId();
        return ResultUtils.success(orderService.findByUserId(userId));
    }

}
