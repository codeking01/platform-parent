package com.youdao.ead.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity //启用Spring Security
public class SpringSecurityConfig {
    // 参考：https://www.kuangstudy.com/bbs/1639180525510221825
    //密码编码
    @Bean
    PasswordEncoder passwordEm(){
        return new BCryptPasswordEncoder();
    }
    //内存中的账号密码
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails use1 = User.withUsername("admin").password(passwordEm().encode("admin")).roles("vip1").build();
        manager.createUser(use1);
        return manager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                //requestMatchers() 是 Spring Security 配置中常用的一种方式，它用于指定哪些请求需要进行安全性保护。
                // 具体来说，该方法使用 RequestMatcher 接口的实现来定义一组 URL 模式或者 Servlet API 请求对象的匹配规则
                // ，以确定哪些请求需要被保护
                .requestMatchers("/","/admin/toLogin/**","/admin/index").permitAll()//permitAll() 表示匹配根路径不需要任何权限即可访问；
                .requestMatchers("/admin/level1/*","/admin/index","/admin/toLogin").hasRole("vip1")//hasRole("vip1") 表示匹配需要用户具有 vip1 权限才能访问；
                .requestMatchers("/admin/level2/*").hasRole("vip2")
                .requestMatchers("/admin/level3/*").hasRole("vip3");
        http.formLogin()//开启表单验证，源码中自带一个默认的login
                .loginPage("/admin/toLogin")//loginPage() 指定登录界面是哪一个，这里指到 "/tologin"
                .usernameParameter("username") //usernameParameter() 指定用户名的参数名
                .passwordParameter("password")
                //.loginProcessingUrl("/admin/login")//loginProcessingUrl() 指定处理登录请求的，也就是登录的 form 提交的地址，这里是 "/login"
                .successForwardUrl("/admin/index");//登陆成功后转跳的页面
//                .permitAll();
        http.csrf().disable();
        //设置退出成功后返回的页面
        http.logout().logoutSuccessUrl("/");
        http.rememberMe();//记住我
        return http.build();
    }
}