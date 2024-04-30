package com.orange.ilbun.controller;

import com.orange.ilbun.model.OrderList;
import com.orange.ilbun.security.CustomUserDetails;
import com.orange.ilbun.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "/user/loginForm";
    }


    @GetMapping("/loginFail")
    public String loginFail() {
        System.out.println("로그인 실패!");
        return "/user/loginFail";
    }
    @GetMapping("/myHome")
    public String myHome(){
        return "/myPage/myHome";
    }

    @GetMapping("/orderList")
    public String orderList(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            Long id = userDetails.getId(); // id 가져오기
            List<OrderList> list = memberService.printOrderList(id);
            model.addAttribute("orderList", list);
        }
        return "/myPage/orderList";
    }

}
