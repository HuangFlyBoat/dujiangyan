package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.LoginInfo;
import com.dujiangyan.tour_server.entity.Admin;
import com.dujiangyan.tour_server.entity.User;
import com.dujiangyan.tour_server.repository.AdminRepository;
import com.dujiangyan.tour_server.repository.UserRepository;
import com.dujiangyan.tour_server.service.AdminService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Resource
    private UserRepository userRepository;


    @Override
    public Admin adminLogin(Admin loginAdmin, HttpServletRequest request) {
        String name = loginAdmin.getName();
        String password = loginAdmin.getPassword();

        Admin admin = adminRepository.findAdminByNameAndPassword(name, password);
        LoginInfo loginInfo = new LoginInfo();
        if (admin != null) {
            admin.setPassword(null);
            loginInfo.setName(name);
            loginInfo.setId(admin.getId());
            request.getSession().setAttribute("login", loginInfo);
            return admin;
        } else {
            return null;
        }
    }

    @Override
    public int editUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getUserId());

        if (userOptional.isPresent()) {
            User userEdit = userOptional.get();
            if (user.getUserName() != null) {
                userEdit.setUserName(user.getUserName());
            }
            if (user.getPhone() != null) {
                userEdit.setPhone(user.getPhone());
            }
            if (user.getEmail() != null) {
                userEdit.setEmail(user.getEmail());
            }
            return userRepository.save(userEdit).getUserId();
        } else {
            // 处理用户不存在的情况
            return -1;
        }
    }
}
