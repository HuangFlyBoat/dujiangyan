package com.dujiangyan.tour_server.controller;
import com.dujiangyan.tour_server.entity.Admin;
import com.dujiangyan.tour_server.repository.AdminRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // 添加其他方法，处理管理员相关的请求和操作
    // 例如，通过用户名获取管理员信息
    @GetMapping("/name/{name}")
    public Admin getAdminByName(@PathVariable String name) {
        return adminRepository.findByName(name);
    }
}
