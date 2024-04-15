package com.orange.ilbun.entity;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int count;
}