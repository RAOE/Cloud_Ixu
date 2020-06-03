package com.example.cloud_service3.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import utils.JsonResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xuyuanfeng
 * @date 2020/6/3
 **/
@RestController
@RequestMapping("")
public class UploadController extends BaseController {
    @RequestMapping("/upload")
    public JsonResult upload(MultipartFile file) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = file.getInputStream();
            fileOutputStream = new FileOutputStream("");
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
                //安静的关闭
            }
        }
        return JsonResult.ok();
    }
}
