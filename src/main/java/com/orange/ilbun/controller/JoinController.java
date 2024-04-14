package com.orange.ilbun.controller;

import com.orange.ilbun.model.Member;
import com.orange.ilbun.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping
    public String joinForm() {
        return "/join/joinForm";
    }

    @PostMapping
    public String join(Member member) {
        joinService.joinProcess(member);
        return "root";
    }

}
