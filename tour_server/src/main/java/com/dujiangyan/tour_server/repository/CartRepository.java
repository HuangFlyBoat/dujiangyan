package com.dujiangyan.tour_server.repository;
import com.dujiangyan.tour_server.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // 可根据需要添加自定义方法
}
