package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.entity.Cart;
import com.dujiangyan.tour_server.service.CartService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 更新购物车（添加，减少，删除）
     */
    @PostMapping("/updateCart")
    public BaseResponse<Integer> updateCart(HttpServletRequest request, @RequestBody Cart cart, @RequestParam Integer speId, @RequestParam Integer productId) {
        return ResultUtils.success(cartService.update(request, cart, speId, productId));
    }

}
