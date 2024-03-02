package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.entity.Attraction;
import com.dujiangyan.tour_server.repository.AttractionRepository;
import com.dujiangyan.tour_server.service.AttractionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {
    private final AttractionRepository attractionRepository;

    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Override
    public List<Attraction> getAttractionList() {
        return attractionRepository.findAllWithImages();

    }

}
