package com.orange.ilbun.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemId;
	private Long orderId;
	private Long userId;
    private int itemId; // 주문 상품 번호
    private String itemName; // 주문 상품 이름
    private String image; // 주문 상품 이미지
    private String imagePath; // 주문 상품 이미지 주소
    private int itemPrice; // 주문 상품 가격
    private int itemCount; // 주문 상품 수량
}
