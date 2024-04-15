package com.orange.ilbun.service;

import com.orange.ilbun.model.Cart;
import com.orange.ilbun.model.CartItem;
import com.orange.ilbun.model.Item;
import com.orange.ilbun.repository.CartMapper;
import com.orange.ilbun.repository.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    ItemMapper itemMapper;

    @Transactional
    public void addCart(Long userId, Long itemId, int count) {
        // 유저 id로 해당 유저의 장바구니 찾기
        System.out.println("유저 아이디: " + userId);
        Cart cart = cartMapper.findByUserId(userId);
        // 장바구니가 존재하지 않는다면 새로 생성
        if (cart == null) {
            System.out.println("카트는 null, userId= " + userId);
            cart = new Cart(userId);
            System.out.println("카트 객체: " + cart.toString());
            cartMapper.save(cart);
            System.out.println("cartMapper.save 실행: ");
        }
        Item item = itemMapper.selectByItemId(itemId);
        System.out.println("상품: " + item);
        Long cartId = cart.getCartId();
        System.out.println("카트아이디: " + cartId);
        Long selectedItemId = item.getItemId();

        // CartItem 객체 생성
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setCount(count);
        System.out.println("카트아이템 체크: " + cartItem.toString());

        // 해당 상품이 장바구니에 이미 존재하는지 확인
        Integer existingItemCount = cartMapper.findCountByCartIdAndItemId(cartItem);
        System.out.println("장바구니에 있나요?: " + existingItemCount);

        // 상품이 장바구니에 존재하지 않는다면 카트상품 생성 후 추가
        if (existingItemCount == null || existingItemCount == 0) {
            cartMapper.insertCartItem(cartItem);
            System.out.println("카트생성 후 아이템 추가");
        }
        // 상품이 장바구니에 이미 존재한다면 수량만 증가
        else {
            cartMapper.updateItemCount(cartItem);
            System.out.println("카트의 아이템 수량 증가");
        }
        // 카트 상품 총 개수 증가
        System.out.println("카트id: " + cart.getCartId());
        cartMapper.updateCartItemCount(cart);
        System.out.println("add카트 서비스 완료");
    }

    public List<Item> getCartAndItems(Long userId) {
        //해당 유저의 카트ID 가져오기
        Long cartId = cartMapper.findCartIdByUserId(userId);
        // 해당 카트에 담긴 아이템 정보와 수량 가져오기
        List<Item> itemsInCart = itemMapper.findItemsByCartId(cartId);
        System.out.println("아이템 리스트: " + itemsInCart);
        return itemsInCart;
    }

    public void deleteCartItem(Long itemId, Long userId) {
        cartMapper.deleteItemInCart(itemId, userId);
    }
}
