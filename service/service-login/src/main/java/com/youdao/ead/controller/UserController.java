package com.youdao.ead.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class UserController {

    @GetMapping("/login")
    public void getLogin() {
        System.out.println("登录成功！");
    }

    @GetMapping("/index")
    public void getIndex() {
        System.out.println("这个是首页!");
    }

    @GetMapping("/error")
    public void getError() {
        System.out.println("这个是错误页面!");
    }
}
