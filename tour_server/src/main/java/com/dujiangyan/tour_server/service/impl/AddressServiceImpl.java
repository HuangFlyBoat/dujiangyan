package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.AddressRepository;
import com.dujiangyan.tour_server.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // 在这里实现 AddressService 接口中定义的方法
}