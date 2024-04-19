package com.orange.ilbun.controller;

import com.orange.ilbun.model.Item;
import com.orange.ilbun.model.Member;
import com.orange.ilbun.security.CustomUserDetails;
import com.orange.ilbun.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("id")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart") // 물건 장바구니에 넣기
    @ResponseBody
    public String addToCart(Principal principal, @RequestParam("itemId") Long itemId, @RequestParam("count") int count, Model model) {
        System.out.println("addTocart 로직 시작");
        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Member member = customUserDetails.getMember();
        Long id = member.getId();
        model.addAttribute("id", id);
        System.out.println("컨트롤러 유저 아이디: "+id);
        cartService.addCart(id, itemId, count);
//        return "redirect:/user/" + id + "/cart";
        return "Success";
    }

    @GetMapping("/cart")
        public String getUserCart(Model model){
        System.out.println("/cart진입");
//        Long userId = (Long) model.getAttribute("userId");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = ((CustomUserDetails) userDetails).getId();
        System.out.println("아이디:"+id);
        // 유저의 카트에 담긴 아이템 정보 가져오기
        List<Item> itemsInCart = cartService.getCartAndItems(id);
        // 뷰에 아이템 정보 전달
        model.addAttribute("itemsInCart", itemsInCart);
        model.addAttribute("id", id);
            return "user/cart";
    }

    @PostMapping("deleteCartItem")
    public String deleteCartItem(@RequestBody Map<String, Long> requestData) {
        Long id = requestData.get("id");
        Long itemId = requestData.get("itemId");
        cartService.deleteCartItem(itemId, id);
        return "redirect:/user/" + id + "/cart";
    }

}
