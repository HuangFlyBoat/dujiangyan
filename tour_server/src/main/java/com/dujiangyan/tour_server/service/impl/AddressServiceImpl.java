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

}