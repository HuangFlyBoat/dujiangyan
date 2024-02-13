package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.repository.DetailRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/detail")
public class DetailController {
    private final DetailRepository detailRepository;

    public DetailController(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    // 添加其他方法，处理详情相关的请求和操作
    // 可以根据需求自行定义接口
}
