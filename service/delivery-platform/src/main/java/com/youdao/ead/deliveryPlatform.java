package com.youdao.ead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class deliveryPlatform {
    public static void main(String[] args) {
        SpringApplication.run(deliveryPlatform.class, args);
    }
}