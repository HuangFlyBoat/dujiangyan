package com.dujiangyan.tour_server.service.repository;

import com.dujiangyan.tour_server.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminByName(String name);

    Admin findAdminByNameAndPassword(String name, String password);
    Admin findByName(String name);
}
