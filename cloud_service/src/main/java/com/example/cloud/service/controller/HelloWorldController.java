package com.example.cloud.service.controller;

import com.example.cloud.service.feign.FeignTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyuanfeng
 * @date 2020/6/3
 **/
@RestController
@RequestMapping("")
public class HelloWorldController {
    @Autowired
    FeignTest feignTest;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/feign")
    public String feign() {
        System.out.println("开始feign调用");
        return feignTest.test("123");
    }
}
