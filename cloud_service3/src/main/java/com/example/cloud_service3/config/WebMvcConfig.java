package com.example.cloud_service3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 徐塬峰
 * @email 986771570@qq.com
 * @date 2019-05-08
 * @description
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${classpath_mapping}")
    private String classpath_mapping;
    @Value("${url_mapping}")
    private String url_mapping;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").
                addResourceLocations(classpath_mapping).
                addResourceLocations(url_mapping);
    }

}
