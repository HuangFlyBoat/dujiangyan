package com.dujiangyan.tour_server.service.repository;
import com.dujiangyan.tour_server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
