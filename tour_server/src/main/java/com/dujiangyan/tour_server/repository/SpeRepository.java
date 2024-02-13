package com.dujiangyan.tour_server.repository;
import com.dujiangyan.tour_server.entity.Spe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SpeRepository extends JpaRepository<Spe, Integer> {
    // 可根据需要添加自定义方法
}
