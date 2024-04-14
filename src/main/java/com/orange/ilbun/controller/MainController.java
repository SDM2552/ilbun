package com.orange.ilbun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "root";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

}
