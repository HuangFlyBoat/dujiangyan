package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.DetailRepository;
import com.dujiangyan.tour_server.service.DetailService;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {
    private final DetailRepository detailRepository;

    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    // 在这里实现 DetailService 接口中定义的方法
}
