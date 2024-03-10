package com.dujiangyan.tour_server.repository;

import com.dujiangyan.tour_server.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByUserId(int userId);

    Address getAddressById(int id);
}
