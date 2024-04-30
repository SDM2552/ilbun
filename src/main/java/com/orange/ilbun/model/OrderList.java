package com.orange.ilbun.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderList {
    private Long orderId;
    private String createDate;
    private Long id;
    private Long orderItemId;
    private String itemName;
    private String image;
    private String imagePath;
    private int itemCount;
    private long itemId;
    private int itemPrice;
}
