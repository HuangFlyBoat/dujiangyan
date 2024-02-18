package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.service.CartService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;


    @GetMapping("/getCartList")
    public BaseResponse<List<CartInfo>> getCartList(HttpServletRequest request) {
        return ResultUtils.success(cartService.getCartList(request));
    }

}
