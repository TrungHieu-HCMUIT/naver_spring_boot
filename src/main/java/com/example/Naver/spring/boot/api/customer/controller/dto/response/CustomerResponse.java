package com.example.naver.spring.boot.api.customer.controller.dto.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Integer cartId;
}
