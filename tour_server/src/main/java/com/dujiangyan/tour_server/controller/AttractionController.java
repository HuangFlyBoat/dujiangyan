package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.entity.Attraction;
import com.dujiangyan.tour_server.service.AttractionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attraction")
public class AttractionController {

    @Resource
    private AttractionService attractionService;

    @GetMapping("/getAttractionList")
    public BaseResponse<List<Attraction>> getAttractionList() {
        return ResultUtils.success(attractionService.getAttractionList());
    }

}
