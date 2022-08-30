package com.example.naver.spring.boot.api.product.controller.dto.request;

import lombok.Data;

@Data
public class ProductConditionParam {
    private Double price;
    private String condition;
}
