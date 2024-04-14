package com.orange.ilbun.security;

import com.mysql.cj.protocol.x.XAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 인증된 사용자 정보 가져오기
        Object principal = authentication.getPrincipal();
        System.out.println("로그인 이후 테스트");
        // 사용자 정보를 콘솔에 출력
        System.out.println("Authenticated user: " + principal.toString());
        // 기본 성공 URL로 리다이렉트
        response.sendRedirect("/");
    }
}
