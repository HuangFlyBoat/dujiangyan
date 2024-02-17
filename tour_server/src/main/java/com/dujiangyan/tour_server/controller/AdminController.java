package com.dujiangyan.tour_server.controller;
import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.entity.Admin;
import com.dujiangyan.tour_server.repository.AdminRepository;
import com.dujiangyan.tour_server.service.AdminService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Resource
    private AdminService adminService;


    @PostMapping("/login")
    public BaseResponse<Admin> adminLogin(@RequestBody Admin loginAdmin, HttpServletRequest request) {
        Admin admin = adminService.adminLogin(loginAdmin, request);
        if (admin == null) {
            return ResultUtils.error(ErrorCode.LOGIN_ERROR);
        } else {
            return ResultUtils.success(admin);
        }
    }

}
