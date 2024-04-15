package com.orange.ilbun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cart {
    private Long cartId;
    private Long userId;
    private int count;

    public Cart(Long userId) {
        this.userId = userId;
    }
}
