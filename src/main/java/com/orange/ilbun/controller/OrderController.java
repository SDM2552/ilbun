package com.orange.ilbun.controller;

import com.orange.ilbun.model.Member;
import com.orange.ilbun.model.OrderItem;
import com.orange.ilbun.security.CustomUserDetails;
import com.orange.ilbun.service.CartService;
import com.orange.ilbun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @PostMapping("/user/{id}/order")
    public String processOrder(@PathVariable Long id, @RequestBody List<OrderItem> selectedItems, HttpSession httpSession, Model model) {
//        CustomUserDetails customUserDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
//        Member member = customUserDetails.getMember();
//        Long id = member.getId();
        model.addAttribute("id", id);
            System.out.println("출력 테스트: "+selectedItems);
        // 기존 세션에 저장된 selectedItems가 있다면 제거
        httpSession.removeAttribute("selectedItems");
        // 주문 정보를 세션에 저장
        httpSession.setAttribute("selectedItems", selectedItems);
        // 주문 페이지로 이동
        return "redirect:/order";
    }
    @GetMapping("/order")
    public String showOrderPage(HttpSession httpSession, Model model) {
        // 세션에서 주문 정보를 가져옴
        List<OrderItem> selectedItems = (List<OrderItem>) httpSession.getAttribute("selectedItems");
        // 모델에 주문 정보를 추가하여 화면에 전달
        model.addAttribute("selectedItems", selectedItems);
        System.out.println("주문 정보: " + selectedItems);
        return "user/order";
    }
    @Transactional
    @PostMapping("/orderSuccess")
    public String orderComplete(Model model, HttpSession httpSession) {
        // 세션에서 주문 정보를 가져옴
        List<OrderItem> selectedItems = (List<OrderItem>) httpSession.getAttribute("selectedItems");
        // 모델에 주문 정보를 추가하여 화면에 전달
        model.addAttribute("selectedItems", selectedItems);
        orderService.addOrder(selectedItems);
        Long id = selectedItems.get(0).getId();
        for (OrderItem item : selectedItems) {
            long itemId = item.getItemId(); // 각 OrderItem의 itemId 추출
            System.out.println("아이디:"+id+"아이템ID:"+itemId);
            cartService.deleteInCart(id, itemId); // orderService 메서드 호출
        }

        //주문 완료 후 세션 제거
        httpSession.removeAttribute("selectedItems");
        return "redirect:/orderSuccess";
    }
    @GetMapping("/removeSelectedItemsFromSession")
    @ResponseBody
    public String removeSelectedItems(HttpSession session) {
        session.removeAttribute("selectedItems"); // 세션 속성 제거
        return "OK";
    }
    @GetMapping("/orderSuccess")
    public String orderCompleteAfter() {
        return "user/orderSuccess";
    }
}
