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
@EnableWebSecurity
public class SpringSecurityConfig {
    //密码编码
    //@Bean
    //PasswordEncoder passwordEm(){
    //    return new BCryptPasswordEncoder();
    //}
    ////内存中的账号密码
    //@Bean
    //public UserDetailsService userDetailsService(){
    //    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //    UserDetails use1 = User.withUsername("admin").password(passwordEm().encode("123456")).roles("vip1").build();
    //    manager.createUser(use1);
    //    return manager;
    //}

    // 配置 SecurityFilterChain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/vip/**").hasRole("admin");
        // 配置登录拦截的
        http.formLogin().loginPage("/admin/login") //loginPage() 指定登录界面是哪一个
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/admin/login")//loginProcessingUrl() 指定处理登录请求的，也就是登录的 form 提交的地址，这里是 "/login"
                .defaultSuccessUrl("/admin/index")//登陆成功后转跳的页面 //loginPage() 指定登录界面是哪一个
                .permitAll();
        // 禁止 csrf
        http.csrf().disable();
        //设置退出成功后返回的页面
        http.logout().logoutSuccessUrl("/");
        // 记住我
        http.rememberMe();
        return http.build();
    }


}
