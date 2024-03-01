package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.service.repository.SpeRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/spe")
public class SpeController {
    private final SpeRepository speRepository;

    public SpeController(SpeRepository speRepository) {
        this.speRepository = speRepository;
    }

    // 添加其他方法，处理规格相关的请求和操作
    // 可以根据需求自行定义接口
}
