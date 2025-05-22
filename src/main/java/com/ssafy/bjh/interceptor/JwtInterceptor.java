package com.ssafy.bjh.interceptor;

import com.ssafy.bjh.config.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "access-token";

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(HEADER_AUTH);

        // 클라이언트가 서버에게 요청을 보내려고 했을 때 사전요청을 한번 보낸다.
        if(request.getMethod().equals("OPTIONS")) {
            return true;
        }

        if(token != null) {
            jwtUtil.vailidate(token);
            return true;
        }

        return false;
    }
}
