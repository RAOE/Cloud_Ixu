package com.example.cloud_service3.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import utils.JsonResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author xuyuanfeng
 * @date 2020/6/3
 **/
@RestController
@RequestMapping("")
public class UploadController extends BaseController {

    @Value("${file_upload_path}")
    private String fileUploadPath;
    /**
     * 文件最大大小
     */
    private final long MAX_SIZE = 20480000000L;

    @RequestMapping("/upload")
    public JsonResult upload(MultipartFile file) {
        if (file == null || file.getSize() <= 0) {
            return JsonResult.errorMsg("文件不存在");
        }
        if (file.getSize() > MAX_SIZE) {
            return JsonResult.errorMsg("文件大小超出了限制");
        }
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        String fileOutPath = null;
        try {
            File out = new File(fileUploadPath);
            if (!out.exists() && !out.isFile()) {
                out.mkdirs();
            }
            String fileName = file.getOriginalFilename();
            inputStream = file.getInputStream();
            fileOutPath = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
            fileOutputStream = new FileOutputStream(fileUploadPath + fileOutPath);
            IOUtils.copy(inputStream, fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return JsonResult.ok(fileOutPath);
    }
}
