package com.dujiangyan.tour_server.repository;

import com.dujiangyan.tour_server.domain.CartInfo;
import com.dujiangyan.tour_server.entity.Cart;
import com.dujiangyan.tour_server.entity.Product;
import com.dujiangyan.tour_server.entity.Spe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


    @Query("SELECT new com.dujiangyan.tour_server.domain.CartInfo(c.id, c.userId,c.number, p.id, p.name, p.img, p.price, p.detailImg, s.speId, s.name) " +
            "FROM Cart c " +
            "JOIN c.product p " +
            "JOIN c.spe s " +
            "WHERE c.userId = :userId")
    List<CartInfo> getCartList(@Param("userId") Integer userId);


    Cart findCartByUserIdAndProductAndSpe(Integer userId, Product product, Spe spe);



}
