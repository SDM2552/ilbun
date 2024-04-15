package com.orange.ilbun.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CartItem {

    private Long cartItemId;
    private Cart cart;
    private Item item;
    private int count; // 카트 상품 갯수

}
