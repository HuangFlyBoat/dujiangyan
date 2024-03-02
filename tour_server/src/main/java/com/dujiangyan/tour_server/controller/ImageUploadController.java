package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class ImageUploadController {

    @PostMapping("/image")
    public BaseResponse uploadImage(@RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }

        try {
            // 将图片文件转换为字节数组
            byte[] bytes = file.getBytes();
            // 使用Apache Commons Codec将字节数组编码为Base64字符串
            String base64 = Base64.encodeBase64String(bytes);
            // 返回Base64编码的字符串
            return ResultUtils.success(base64);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR);
        }
    }
}
