package com.dujiangyan.tour_server.config;

import com.dujiangyan.tour_server.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 将 LoginInterceptor 注册为一个拦截器，并将其应用于所有的请求路径上
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有请求都执行该拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }
}