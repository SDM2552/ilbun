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

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("userId")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart") // 물건 장바구니에 넣기
    public String addToCart(Principal principal, @RequestParam("itemId") Long itemId, @RequestParam("count") int count, Model model) {
        System.out.println("addTocart 로직 시작");
        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
        Member member = customUserDetails.getMember();
        Long userId = member.getId();
        model.addAttribute("userId", userId);
        System.out.println("컨트롤러 유저 아이디: "+userId);
        cartService.addCart(userId, itemId, count);

        return "redirect:/user/" + userId + "/cart";
    }

    @GetMapping("/user/{userId}/cart")
        public String getUserCart(Model model){
        Long userId = (Long) model.getAttribute("userId");
        // 유저의 카트에 담긴 아이템 정보 가져오기
        List<Item> itemsInCart = cartService.getCartAndItems(userId);
        // 뷰에 아이템 정보 전달
        model.addAttribute("itemsInCart", itemsInCart);
            return "user/cart";
    }

    @PostMapping("deleteCartItem")
    public String deleteCartItem(@RequestBody Map<String, Long> requestData) {
        Long userId = requestData.get("userId");
        Long itemId = requestData.get("itemId");
        cartService.deleteCartItem(itemId, userId);
        return "redirect:/user/" + userId + "/cart";
    }

}
