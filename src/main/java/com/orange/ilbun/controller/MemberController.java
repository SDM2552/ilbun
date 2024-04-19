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


    @GetMapping("/loginFail")
    public String loginFail() {
        System.out.println("로그인 실패!");
        return "/user/loginFail";
    }

    @GetMapping("/orderList")
    public String orderList(){

        return "/myPage/orderList";
    }

}
