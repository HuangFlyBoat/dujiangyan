package com.dujiangyan.tour_server.config;

import com.dujiangyan.tour_server.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有请求都执行该拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域请求的路径
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许所有源，或者替换为具体的域名，例如"http://example.com"
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的HTTP方法
                .allowCredentials(true) // 是否允许发送Cookie信息
                .maxAge(3600); // 预检请求的缓存时间（秒），在这段时间内，对于相同的跨域请求将不再进行预检
    }
}
