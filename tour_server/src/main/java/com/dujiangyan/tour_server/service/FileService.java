package com.dujiangyan.tour_server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {


    String uploadFile(MultipartFile file) throws IOException;
}
