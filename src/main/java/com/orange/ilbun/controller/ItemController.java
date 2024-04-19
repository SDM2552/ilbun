package com.orange.ilbun.controller;

import com.orange.ilbun.model.Item;
import com.orange.ilbun.model.Member;
import com.orange.ilbun.security.CustomUserDetails;
import com.orange.ilbun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public String itemList(Model model){
        List<Item> list = itemService.printItemList();
        model.addAttribute("list", list);
        return "item/list";
    }
    @GetMapping("/item")
    public String item(@RequestParam Long itemId, Principal principal, Model model) {
        Item item = itemService.itemdetail(itemId);
//        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
//        Member member = customUserDetails.getMember();
//        Long id = member.getId();
        model.addAttribute("item", item);
//        model.addAttribute("id", id);
        System.out.println("item 페이지로 이동");
        return "item/item";
    }
    @GetMapping("/addItems")
    public String addItems() {
        return "item/addItems";
    }
    @PostMapping("/add")
    public String addItems2(Item item, MultipartFile imgFile) throws IllegalStateException, IOException {
        itemService.insertItem(item, imgFile);
        System.out.println();
        return "redirect:/item/addItems";
    }

}
