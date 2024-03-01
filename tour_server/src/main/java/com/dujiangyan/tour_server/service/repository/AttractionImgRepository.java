package com.dujiangyan.tour_server.service.repository;
import com.dujiangyan.tour_server.entity.AttractionImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AttractionImgRepository extends JpaRepository<AttractionImg, Integer> {
    
}
