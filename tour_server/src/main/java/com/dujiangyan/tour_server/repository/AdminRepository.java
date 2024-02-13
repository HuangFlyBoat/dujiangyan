package com.dujiangyan.tour_server.repository;

import com.dujiangyan.tour_server.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByName(String name);
}
