package com.dujiangyan.tour_server.interceptor;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    // 放行路径
    private static final List<String> EXEMPT_PATHS = Arrays.asList("/user/register", "/user/login","/admin/login");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        log.info("🚀 ~ file:AuthenticationInterceptor.java method:preHandle line:26 -----用户请求接口:" + path);

        // 检查请求路径是否需要放行
        if (EXEMPT_PATHS.contains(path)) {
            return true;
        }

        // 检查用户是否已经登录
        Object userObj = request.getSession().getAttribute("login");
        User user = (User) userObj;

        // 用户未登录时的响应
        if (user == null) {
            BaseResponse baseResponse = ResultUtils.error(ErrorCode.NOT_LOGIN);
            String jsonResponse = new ObjectMapper().writeValueAsString(baseResponse);
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
            return false;
        }

        // 用户已登录
        return true;


    }
}