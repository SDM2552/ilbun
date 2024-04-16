package com.orange.ilbun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    @Column(nullable = false)
    private Long cartId;
    @Column(nullable = false)
    private Long itemId;
    @Column(nullable = false)
    private int quantity;
}
