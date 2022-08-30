package com.example.naver.spring.boot.api.cart_item.service;

import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsAddToCartRequest;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsFromCartParam;
import com.example.naver.spring.boot.api.cart_item.controller.dto.response.ItemInCartResponse;

import java.util.List;

public interface CartItemService {
    boolean addItemsToCart(Integer customerId, ItemsAddToCartRequest itemsAddToCart);
    List<ItemInCartResponse> getItemsFromCart(Integer customerId, ItemsFromCartParam itemsFromCartParam);
}
