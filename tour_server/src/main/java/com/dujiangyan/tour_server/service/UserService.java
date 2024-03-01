package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.domain.UserRegisterRequest;
import com.dujiangyan.tour_server.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @return 如果登录成功，返回用户的信息；如果登录失败，返回null。
     */
    User userRegister(UserRegisterRequest userRegisterRequest);

    /**
     * 用户登录
     * @param loginUser
     * @param request
     * @return
     */
    User userLogin(User loginUser, HttpServletRequest request);


    /**
     * 获取用户列表
     * @return
     */
    List<User> userList();




}
