package com.microservices.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final RestTemplate restTemplate;

    @GetMapping("findTaxi")
    public String findTaxi() {
        return restTemplate.getForObject("http://localhost:8082/api/v1/driver/taxi", String.class);
    }
}
