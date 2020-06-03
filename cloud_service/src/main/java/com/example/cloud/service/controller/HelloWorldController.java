package com.example.cloud.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyuanfeng
 * @date 2020/6/3
 **/
@RestController
@RequestMapping("")
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
