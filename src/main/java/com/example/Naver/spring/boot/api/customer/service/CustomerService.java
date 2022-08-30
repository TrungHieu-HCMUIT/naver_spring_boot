package com.example.naver.spring.boot.api.customer.service;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import com.example.naver.spring.boot.api.customer.controller.dto.request.CustomerCreateRequest;
import com.example.naver.spring.boot.api.customer.repository.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerCreateRequest customerCreateRequest);
    List<Customer> getCustomers();
    Customer findCustomer(Integer customerId);
    Customer updateCartToCustomer(Integer customerId, Cart cart);
}
