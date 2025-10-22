package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.CartItem;

public interface CartService {
    CartItem checkQty(CartItem cartItem);
    int add(CartItem cartItem);
}
