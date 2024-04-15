package com.orange.ilbun.controller;

import com.orange.ilbun.model.Item;
import com.orange.ilbun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String item(@RequestParam Long itemId, Model model) {
        Item item = itemService.itemdetail(itemId);
        model.addAttribute("item", item);
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
