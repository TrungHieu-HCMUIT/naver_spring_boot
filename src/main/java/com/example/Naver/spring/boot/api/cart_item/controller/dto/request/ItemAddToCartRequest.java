package com.example.naver.spring.boot.api.cart_item.controller.dto.request;

import lombok.Data;

@Data
public class ItemAddToCartRequest {
    private Integer productId;
    private Integer quantity;
}
