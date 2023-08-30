package com.youdao.ead;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-login")
@Repository
public interface LoginFeignClient {
    @GetMapping("/admin/login")
    void getLogin();
}