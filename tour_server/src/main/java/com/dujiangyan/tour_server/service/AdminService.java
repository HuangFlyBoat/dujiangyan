package com.dujiangyan.tour_server.service;

import com.dujiangyan.tour_server.entity.Admin;
import jakarta.servlet.http.HttpServletRequest;

public interface AdminService {
    Admin adminLogin(Admin admin, HttpServletRequest request);
}
