package com.orange.ilbun.controller;

import com.orange.ilbun.model.OrderItem;
import com.orange.ilbun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/user/{userId}/order")
    public String processOrder(@PathVariable Long userId, @RequestBody List<OrderItem> selectedItems, HttpSession httpSession) {
        System.out.println("출력 테스트: "+selectedItems);
        // 기존 세션에 저장된 selectedItems가 있다면 제거
        httpSession.removeAttribute("selectedItems");
        // 주문 정보를 세션에 저장
        httpSession.setAttribute("selectedItems", selectedItems);
        // 주문 페이지로 이동
        return "redirect:/user/" + userId + "/cart";
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
    @PostMapping("/orderSuccess")
    public String orderComplete(Model model, HttpSession httpSession) {
        // 세션에서 주문 정보를 가져옴
        List<OrderItem> selectedItems = (List<OrderItem>) httpSession.getAttribute("selectedItems");
        // 모델에 주문 정보를 추가하여 화면에 전달
        model.addAttribute("selectedItems", selectedItems);
        orderService.addOrder(selectedItems);
        //주문 완료 후 세션 제거
        httpSession.removeAttribute("selectedItems");
        return "redirect:/orderSuccess";
    }
    @GetMapping("/orderSuccess")
    public String orderCompleteAfter() {
        return "user/orderSuccess";
    }
}
