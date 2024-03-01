package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.domain.LoginInfo;
import com.dujiangyan.tour_server.entity.Cart;
import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.entity.Spe;
import com.dujiangyan.tour_server.service.repository.CartRepository;
import com.dujiangyan.tour_server.service.repository.ProductRepository;
import com.dujiangyan.tour_server.service.repository.SpeRepository;
import com.dujiangyan.tour_server.service.CartService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartRepository cartRepository;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private SpeRepository speRepository;

    @Override
    public List<CartInfo> getCartList(HttpServletRequest request) {
        LoginInfo userInfo = (LoginInfo) request.getSession().getAttribute("login");
        return cartRepository.getCartList(userInfo.getId());
    }

    @Override
    public int update(HttpServletRequest request, Cart cart, Integer speId, Integer productId) {
        // 获取用户id
        LoginInfo userInfo = (LoginInfo) request.getSession().getAttribute("login");
        Integer userId = userInfo.getId();
        // 根据用户id、商品id和规格id查询购物车记录
        Cart existingCart = cartRepository.findCartByUserIdAndProduct_IdAndSpe_SpeId(userId, speId, productId);

        if (existingCart != null) {
            // 如果找到了现有的记录，更新数量
            existingCart.setNumber(existingCart.getNumber() + cart.getNumber());
            if (existingCart.getNumber() <= 0) {
                // 如果数量为0，删除这条记录
                cartRepository.delete(existingCart);
                return 0; // 假设删除成功返回0
            } else {
                // 数量大于0，保存更新的记录
                cartRepository.save(existingCart);
                return existingCart.getId();
            }
        } else {
            // 如果没有找到现有的记录，插入新的记录
            // 根据商品id和规格id查询响应对象
            Spe spe = speRepository.findById(speId)
                    .orElseThrow(() -> new RuntimeException("Spe not found"));
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            cart.setProduct(product);
            cart.setSpe(spe);
            cart.setUserId(userId);
            cartRepository.save(cart);
            return cart.getId();
        }
    }


}
