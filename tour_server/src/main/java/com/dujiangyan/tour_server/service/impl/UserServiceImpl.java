package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.LoginInfo;
import com.dujiangyan.tour_server.domain.UserRegisterRequest;
import com.dujiangyan.tour_server.entity.User;
import com.dujiangyan.tour_server.repository.UserRepository;
import com.dujiangyan.tour_server.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User userRegister(UserRegisterRequest userRegisterRequest) {
        String username = userRegisterRequest.getUserName();
        String password = userRegisterRequest.getPassword();
        String password2 = userRegisterRequest.getPassword2();

        // 判断两次密码是否一致
        if (!password.equals(password2)) {
            return null;
        }

        // 检查用户名是否已经被注册
        User existingUser = userRepository.findUserByUserName(username);
        if (existingUser != null) {
            log.info("User already exists");
            return null;
        }


        // 创建新的用户对象
        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPassword(passwordEncoder.encode(password));  // 加密密码
        newUser.setPhone(userRegisterRequest.getPhone());
        newUser.setEmail(userRegisterRequest.getEmail());
        return userRepository.save(newUser);


    }

    @Override
    public User userLogin(User loginUser, HttpServletRequest request) {
        String username = loginUser.getUserName();
        String password = loginUser.getPassword();

        User user = userRepository.findUserByUserName(username);
        LoginInfo loginInfo = new LoginInfo();
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            user.setPassword(null);
            loginInfo.setName(username);
            loginInfo.setId(user.getUserId());
            request.getSession().setAttribute("login", loginInfo);
            return user;
        } else {
            return null;
        }
    }

}
