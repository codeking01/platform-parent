package com.youdao.ead.controller;

import com.youdao.ead.entity.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    //@GetMapping("/toLogin/{username}/{password}")
    //public void toLogin(@PathVariable String username, @PathVariable String password) {
    //    System.out.println(username);
    //    System.out.println(password);
    //}
    @GetMapping("/toLogin")
    public void formToLogin(@RequestBody LoginForm loginForm) {
        System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());
        // todo 认证授权
        // 没用做了，相信后人的智慧，这个其实很简单
    }


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


    @GetMapping("/level1")
    public void getLevel1() {
        System.out.println("这个是level1!");
    }

}
