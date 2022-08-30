package com.example.naver.spring.boot.api.cart.service;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;

public interface CartService {
    Cart getOrCreateNewCart(int customerId);
}
