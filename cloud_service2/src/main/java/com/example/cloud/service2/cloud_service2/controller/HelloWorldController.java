package com.example.cloud.service2.cloud_service2.controller;

import org.springframework.web.bind.annotation.PathVariable;
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
        return "/hello2";
    }

    @RequestMapping("/user/{userId}")
    public String feign(@PathVariable String userId) {
        return "feign" + userId;
    }
}
