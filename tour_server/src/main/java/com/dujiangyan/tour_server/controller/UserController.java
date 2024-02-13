package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 添加其他方法，处理用户相关的请求和操作
    // 可以根据需求自行定义接口
}
