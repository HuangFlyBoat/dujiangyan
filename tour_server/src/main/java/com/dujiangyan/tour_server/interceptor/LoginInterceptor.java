package com.dujiangyan.tour_server.interceptor;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.dujiangyan.tour_server.domain.LoginInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    // 放行路径
    private static final Set<String> EXEMPT_PATHS = new HashSet<>(Arrays.asList(
            "/user/register",
            "/user/login",
            "/admin/login",
            "/product/getProductList",
            "/product/getDetail",
            "/file/image",
            "/product/delete"
    ));

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String path = request.getRequestURI();
        log.info("🚀 ~ file:AuthenticationInterceptor.java method:preHandle line:26 -----用户请求接口: {} [{}]", path, request.getMethod());

        // 检查请求路径是否需要放行
        if (EXEMPT_PATHS.contains(path)) {
            return true;
        }

        // 检查用户是否已经登录
        LoginInfo userInfo = (LoginInfo) request.getSession().getAttribute("login");

        // 用户未登录时的响应
        if (userInfo == null) {
            BaseResponse baseResponse = ResultUtils.error(ErrorCode.NOT_LOGIN);
            String jsonResponse = objectMapper.writeValueAsString(baseResponse);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
            return false;
        }

        // 用户已登录
        return true;
    }
}
