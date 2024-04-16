package com.orange.ilbun.repository;

import com.orange.ilbun.model.OrderInfo;
import com.orange.ilbun.model.OrderItem;
import com.orange.ilbun.model.OrderSummary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void save(OrderInfo orderInfo);

    void saveOrderInfo(OrderInfo orderInfo);

    void saveOrderItems(List<OrderItem> selectedItems);

    List<OrderItem> getOrderItemsByOrderId(Long orderId);

    List<OrderSummary> getOrderSummary(Long userId);
}
