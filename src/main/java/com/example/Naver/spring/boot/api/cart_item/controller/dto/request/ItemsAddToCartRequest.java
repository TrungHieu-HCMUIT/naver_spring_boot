package com.example.naver.spring.boot.api.cart_item.controller.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ItemsAddToCartRequest {
    private List<ItemAddToCartRequest> items;
}
