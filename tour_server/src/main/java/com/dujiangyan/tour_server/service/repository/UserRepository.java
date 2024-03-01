package com.dujiangyan.tour_server.service.repository;

import com.dujiangyan.tour_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserName(String username);
}
