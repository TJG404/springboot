package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.CartItemDto;
import com.springboot.shoppy_fullstack_app.dto.CartListResponse;

import java.util.List;

public interface CartService {
    int deleteItem(CartItemDto cartItem);
    List<CartListResponse> findList(CartItemDto cartItem);
    CartItemDto getCount(CartItemDto cartItem);
    int updateQty(CartItemDto cartItem);
    CartItemDto checkQty(CartItemDto cartItem);
    int add(CartItemDto cartItem);
}
