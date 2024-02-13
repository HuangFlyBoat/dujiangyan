package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.UserRepository;
import com.dujiangyan.tour_server.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 在这里实现 UserService 接口中定义的方法
}
