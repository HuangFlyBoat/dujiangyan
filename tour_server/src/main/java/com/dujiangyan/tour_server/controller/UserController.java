package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.domain.UserRegisterRequest;
import com.dujiangyan.tour_server.entity.User;
import com.dujiangyan.tour_server.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @PostMapping("/register")
    public BaseResponse register(@RequestBody UserRegisterRequest userRegisterRequest) {
        long userId = userService.userRegister(userRegisterRequest);
        if (userId == -1) {
            return ResultUtils.error(ErrorCode.REGISTER_ERROR);
        } else {
            User user = new User();
            user.setUserId(userId);
            return ResultUtils.success(user);
        }
    }

    @PostMapping("/login")
    public BaseResponse<User> login(@RequestBody User loginUser, HttpServletRequest request) {
        User user = userService.userLogin(loginUser, request);
        if (user == null) {
            return ResultUtils.error(ErrorCode.LOGIN_ERROR);
        } else {
            return ResultUtils.success(user);
        }
    }

    @GetMapping("/test")
    public BaseResponse test() {
        return ResultUtils.success("test");
    }
}
