package com.example.naver.spring.boot.api.cart_item.controller.dto.request;

import lombok.Data;

@Data
public class ItemsFromCartParam {
    private String productName;
    private Integer offset;
    private Integer limit;
}
