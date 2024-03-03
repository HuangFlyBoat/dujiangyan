package com.dujiangyan.tour_server.controller;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.service.FileService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class ImageUploadController {

    @Resource
    private FileService fileService;


    /**
     * 图片上传,注意一定使用PostMapping
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/image")
    public BaseResponse imageUpload(@RequestParam("file") MultipartFile file) throws IOException {

        //上传文件
        String url = fileService.uploadFile(file);
        if (url == null || "".equals(url)) {
            return ResultUtils.error(ErrorCode.UPLOAD_ERROR);
        }
        Map<String, String> res = new HashMap<>();
        res.put("url", url);
        return ResultUtils.success(res);

    }

}
