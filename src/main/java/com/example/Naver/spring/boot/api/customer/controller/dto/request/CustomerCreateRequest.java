package com.example.naver.spring.boot.api.customer.controller.dto.request;

import lombok.Data;

@Data
public class CustomerCreateRequest {
    private String name;
    private String address;
    private String phone;
}
