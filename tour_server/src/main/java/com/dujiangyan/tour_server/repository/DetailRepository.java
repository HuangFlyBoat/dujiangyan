package com.dujiangyan.tour_server.repository;

import com.dujiangyan.tour_server.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    // 可根据需要添加自定义方法
}
