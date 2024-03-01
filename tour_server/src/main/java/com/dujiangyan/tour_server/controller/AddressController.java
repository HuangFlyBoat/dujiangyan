package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.entity.Address;
import com.dujiangyan.tour_server.service.repository.AddressRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // 添加其他方法，处理地址相关的请求和操作
    // 例如，获取用户的所有地址
    @GetMapping("/user/{userId}")
    public List<Address> getUserAddresses(@PathVariable int userId) {
        return addressRepository.findByUserId(userId);
    }
}
