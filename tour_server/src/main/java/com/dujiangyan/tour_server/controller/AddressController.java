package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.entity.Address;
import com.dujiangyan.tour_server.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;


    // 根据用户ID查找地址
    @GetMapping("/user")
    public BaseResponse<List<Address>> getUserAddresses(@RequestParam("userId") int userId) {
        return ResultUtils.success(addressService.findByUserId(userId));
    }


    // 新增或更新地址
    @PostMapping("/createOrUpdate")
    public BaseResponse<Address> createOrUpdateAddress(@RequestBody Address address) {
        return ResultUtils.success(addressService.save(address));
    }

    // 根据ID删除地址
    @GetMapping("/delete")
    public BaseResponse deleteAddress(@RequestParam("id") int id) {
        int res = addressService.deleteById(id);
        if (res == 1) {
            return ResultUtils.success(ErrorCode.SUCCESS);
        } else {
            return ResultUtils.error(ErrorCode.EDIT_ERROR);
        }
    }
}
