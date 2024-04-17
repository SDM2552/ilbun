package com.orange.ilbun.controller;

import com.orange.ilbun.model.Item;
import com.orange.ilbun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ItemService itemService;
    @GetMapping("/")
    public String root(Model model) {
        List<Item> list = itemService.printItemList();
        model.addAttribute("items", list);
        return "main";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/main")
    public String main(Model model) {
        List<Item> list = itemService.printItemList();
        model.addAttribute("items", list);
        return "root";
    }
}
