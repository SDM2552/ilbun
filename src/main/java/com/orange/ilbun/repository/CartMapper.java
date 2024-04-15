package com.orange.ilbun.repository;

import com.orange.ilbun.model.Cart;
import com.orange.ilbun.model.CartItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    Cart findByUserId(Long userId);
    Long findCartIdByUserId(Long userId);
    void save(Cart cart);
    Integer findCountByCartIdAndItemId(CartItem cartItem);
    void insertCartItem(CartItem cartItem);
    void updateItemCount(CartItem cartItem);
    void updateCartItemCount(Cart cart);
    void deleteItemInCart(Long itemId, Long userId);


}
