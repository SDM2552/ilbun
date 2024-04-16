package com.orange.ilbun.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.orange.ilbun.model.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@SessionAttributes("selectedItems")
public class OrderSessionService {

	public void saveSelectedItemsToSession(HttpSession session, List<OrderItem> selectedItems) {
        // 세션에 주문 정보를 저장합니다.
        session.setAttribute("selectedItems", selectedItems);
    }
    public List<OrderItem> getSelectedItemsFromSession(HttpSession session) {
        // 세션에서 주문 정보를 가져옵니다.
        return (List<OrderItem>) session.getAttribute("selectedItems");
    }
    public void clearSelectedItemsFromSession(HttpSession session) {
        // 세션에서 주문 정보를 삭제합니다.
        session.removeAttribute("selectedItems");
    }
}
