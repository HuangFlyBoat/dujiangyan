package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class ImageUploadController {

    @PostMapping("/image")
    public BaseResponse uploadImage(@RequestParam("image") MultipartFile file) {
        long MAX_SIZE = 5 * 1024 * 1024; // 5MB in bytes

        if (file.isEmpty()) {
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }

        if (file.getSize() > MAX_SIZE) {
            // 文件太大，返回自定义错误
            return ResultUtils.error(ErrorCode.FILE_TOO_LARGE); // 确保你有一个对应的错误码
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
