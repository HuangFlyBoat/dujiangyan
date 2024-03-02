package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.entity.Address;

import java.util.List;

public interface AddressService {
    /**
     * 根据用户ID查找地址
     * @param userId 用户ID
     * @return
     */
    public List<Address> findByUserId(int userId);


    /**
     * 添加或更新地址
     * @param address 地址
     * @return
     */
    public Address save(Address address);

    // 根据ID删除地址
    public int deleteById(int id);
}