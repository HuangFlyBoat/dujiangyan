package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.domain.LoginInfo;
import com.dujiangyan.tour_server.entity.Admin;
import com.dujiangyan.tour_server.repository.AdminRepository;
import com.dujiangyan.tour_server.service.AdminService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;


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
}
