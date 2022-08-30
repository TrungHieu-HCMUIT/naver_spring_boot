package com.example.naver.spring.boot.api.customer.controller.dto.response;

import lombok.Data;

@Data
public class CustomerSimpleResponse {
    private Integer id;
    private String name;
    private String address;
    private String phone;
}
