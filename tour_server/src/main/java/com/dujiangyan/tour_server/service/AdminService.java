package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.entity.Admin;
import com.dujiangyan.tour_server.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface AdminService {
    Admin adminLogin(Admin admin, HttpServletRequest request);

    int editUser(User user);
}
