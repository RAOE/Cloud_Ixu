package com.example.cloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xuyuanfeng
 * @date 2020/6/3
 **/
@FeignClient(name = "service2")
public interface FeignTest {
    @RequestMapping(method = RequestMethod.GET, path = "user/{userId}")
    String test(@PathVariable("userId") String userId);
}
