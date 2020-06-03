package com.example.cloud.service2.cloud_service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudService2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudService2Application.class, args);
    }

}
