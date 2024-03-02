package com.dujiangyan.tour_server.service.impl;

import com.dujiangyan.tour_server.repository.SpeRepository;
import com.dujiangyan.tour_server.service.SpeService;
import org.springframework.stereotype.Service;

@Service
public class SpeServiceImpl implements SpeService {
    private final SpeRepository speRepository;

    public SpeServiceImpl(SpeRepository speRepository) {
        this.speRepository = speRepository;
    }

}
