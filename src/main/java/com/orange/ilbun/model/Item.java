package com.orange.ilbun.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Item {

    private Long itemId;
    @NonNull
    private String category;
    @NonNull
    private String name;
    @NonNull
    private int price;
    @NonNull
    private int quantity;
    @NonNull
    private int sales;
    @NonNull
    private String description;
    @NonNull
    private String image;
    private String imagePath;
    private String regDate;
    private int cartItemQuantity;
}

