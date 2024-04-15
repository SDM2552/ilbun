package com.orange.ilbun.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderItem {

	private Long orderItemId;
	private Long orderId;
	private Long userId;
	
    private int itemId; // 주문 상품 번호
    private String itemName; // 주문 상품 이름
    private String image; // 주문 상품 이미지
    private int itemPrice; // 주문 상품 가격
    private int itemCount; // 주문 상품 수량
 

}
