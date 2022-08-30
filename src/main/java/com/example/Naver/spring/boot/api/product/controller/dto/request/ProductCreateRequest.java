package com.example.naver.spring.boot.api.product.controller.dto.request;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String name;
    private String type;
    private String size;
    private Double price;
}
