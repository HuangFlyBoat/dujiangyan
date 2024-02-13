package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.AttractionRepository;
import com.dujiangyan.tour_server.service.AttractionService;
import org.springframework.stereotype.Service;

@Service
public class AttractionServiceImpl implements AttractionService {
    private final AttractionRepository attractionRepository;

    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    // 在这里实现 AttractionService 接口中定义的方法
}
