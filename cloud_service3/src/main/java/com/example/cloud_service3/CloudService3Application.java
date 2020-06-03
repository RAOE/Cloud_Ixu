package com.example.cloud_service3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudService3Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudService3Application.class, args);
    }
}
