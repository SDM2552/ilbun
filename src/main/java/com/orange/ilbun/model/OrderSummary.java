package com.orange.ilbun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummary {
    private Long orderId;
    private String createDate;
    private int totalItemCount;
    private int totalAmount;
}