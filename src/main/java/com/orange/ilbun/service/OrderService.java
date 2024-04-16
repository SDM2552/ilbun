package com.orange.ilbun.service;

import com.orange.ilbun.model.OrderInfo;
import com.orange.ilbun.model.OrderItem;
import com.orange.ilbun.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderSessionService orderSessionService;
    @Transactional
    public void addOrder(List<OrderItem> selectedItems) {
        // OrderInfo 객체 생성
        OrderInfo orderInfo = new OrderInfo(selectedItems.get(0).getUserId());
        orderMapper.save(orderInfo);
        System.out.println("주문정보: "+orderInfo);
        // OrderItem에 orderId 설정 후 추가
        for (OrderItem item : selectedItems) {
            item.setOrderId(orderInfo.getOrderId());
        }
        orderInfo.setOrderItems(selectedItems);
        System.out.println("주문정보2: "+orderInfo);


        // 주문 정보와 주문 항목들을 저장
//	    orderMapper.saveOrderInfo(orderInfo);
        orderMapper.saveOrderItems(selectedItems);
        System.out.println("주문정보3: "+orderInfo);
        System.out.println("주문정보4: "+selectedItems);
        // 저장된 주문 항목 리스트를 가져와서 콘솔에 출력
        List<OrderItem> savedItems = orderMapper.getOrderItemsByOrderId(orderInfo.getOrderId());
        for (OrderItem item : savedItems) {
            System.out.println("저장된 OrderItem: " + item);
        }
    }
}
