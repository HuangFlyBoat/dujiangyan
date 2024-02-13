package com.dujiangyan.tour_server.repository;
import com.dujiangyan.tour_server.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // 可根据需要添加自定义方法
}
