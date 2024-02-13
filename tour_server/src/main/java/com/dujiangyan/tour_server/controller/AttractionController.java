package com.dujiangyan.tour_server.controller;
import com.dujiangyan.tour_server.entity.Attraction;
import com.dujiangyan.tour_server.repository.AttractionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
    private final AttractionRepository attractionRepository;

    public AttractionController(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    // 添加其他方法，处理景点相关的请求和操作
    // 例如，根据关键字搜索景点
    @GetMapping("/search")
    public List<Attraction> searchAttractions(@RequestParam String keyword) {
        return attractionRepository.findByTitleContaining(keyword);
    }
}
