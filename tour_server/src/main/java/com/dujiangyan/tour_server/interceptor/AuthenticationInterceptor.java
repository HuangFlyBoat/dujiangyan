package com.dujiangyan.tour_server.interceptor;

import com.dujiangyan.tour_server.common.BaseResponse;
import com.dujiangyan.tour_server.common.ErrorCode;
import com.dujiangyan.tour_server.common.ResultUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return true; // 继续请求处理
        } else {
            BaseResponse<Object> baseResponse = ResultUtils.error(ErrorCode.NOT_LOGIN);
            String jsonResponse = new ObjectMapper().writeValueAsString(baseResponse); // 使用Jackson库转换对象为JSON字符串
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置状态码为401
            response.setContentType("application/json"); // 设置响应体的内容类型为JSON
            response.getWriter().write(jsonResponse); // 设置响应体的内容
            return false; // 停止请求处理
        }
    }


}