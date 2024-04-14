package com.orange.ilbun.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MemberController {

    @GetMapping("/login")
    public String login() {
        return "/user/loginForm";
    }

//    @PostMapping("/user/loginPr")
//    public String loginAfter(HttpServletRequest request, HttpSession session) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("출력 테스트");
//
//        // 사용자가 인증되어 있지 않은 경우 처리
//        if (authentication == null || !authentication.isAuthenticated()) {
//            System.out.println("사용자가 인증되지 않았습니다.");
//            return "/";
//        }
//
//        // 사용자가 인증되어 있을 경우, 사용자 정보 출력
//        String username = authentication.getName(); // 사용자명 가져오기
//        System.out.println("현재 로그인한 사용자: " + username);
//        System.out.println("로그인 완료");
//
//        // 세션 정보 출력
//        System.out.println("세션 ID: " + session.getId());
//        System.out.println("세션에 저장된 로그인 정보: " + session.getAttribute("SPRING_SECURITY_CONTEXT"));
//        return "redirect:/";
//    }

    @GetMapping("/loginFail")
    public String loginFail() {
        System.out.println("로그인 실패!");
        return "/user/loginFail";
    }
}
