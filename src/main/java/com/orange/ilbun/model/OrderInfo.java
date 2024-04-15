package com.orange.ilbun.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderInfo {
    private Long orderId;
    private Long userId;
    private String createDate;
    private List<OrderItem> orderItems; // 상품 목록을 저장할 리스트 필드

    // 생성자를 이용한 초기화
    public OrderInfo(Long userId) {
        this.userId = userId;
        this.createDate = LocalDate.now().toString();
        this.orderItems = new ArrayList<>();
    }
}
