package com.dujiangyan.tour_server.repository;
import com.dujiangyan.tour_server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // 可根据需要添加自定义方法
}
