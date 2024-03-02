package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.entity.Address;
import com.dujiangyan.tour_server.repository.AddressRepository;
import com.dujiangyan.tour_server.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressRepository addressRepository;


    @Override
    public List<Address> findByUserId(int userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public int deleteById(int id) {
        addressRepository.deleteById(id);
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            return -1;
        } else {
            return 1;
        }
    }
}