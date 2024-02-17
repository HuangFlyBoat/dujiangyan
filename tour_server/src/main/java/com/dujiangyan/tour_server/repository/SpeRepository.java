package com.dujiangyan.tour_server.repository;
import com.dujiangyan.tour_server.entity.Spe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeRepository extends JpaRepository<Spe, Integer> {
    List<Spe> findAllByProductId(int productId);
}
