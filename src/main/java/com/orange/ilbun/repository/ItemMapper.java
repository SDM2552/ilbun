package com.orange.ilbun.repository;

import com.orange.ilbun.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemMapper {

    @Select("select * from item")
    List<Item> selectAll();
    @Select("select * from item where item_id=#{itemId}")
    Item selectByItemId(Long itemId);
    void insertItem(Item item);
    @Select("SELECT i.item_Id, i.category, i.name, i.price, i.image, i.image_Path, ci.quantity AS cart_item_quantity " +
            "FROM item i " +
            "JOIN cart_item ci ON i.item_Id = ci.item_id " +
            "WHERE ci.cart_id = #{cartId}")
    List<Item> findItemsByCartId(Long cartId);
}
