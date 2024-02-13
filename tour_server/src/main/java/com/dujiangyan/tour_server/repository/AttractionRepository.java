package com.dujiangyan.tour_server.repository;
import com.dujiangyan.tour_server.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
    List<Attraction> findByTitleContaining(String keyword);
}
