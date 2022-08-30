package com.example.naver.spring.boot.api.cart.service;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import com.example.naver.spring.boot.api.customer.repository.entity.Customer;
import com.example.naver.spring.boot.api.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CustomerService customerService;

    public Cart getOrCreateNewCart(int customerId) {
        Customer customer = customerService.findCustomer(customerId);
        if (customer.getCart() == null) {
            Cart newCart = new Cart();
            Customer updatedCustomer = customerService.updateCartToCustomer(customerId, newCart);
            return updatedCustomer.getCart();
        }
        return customer.getCart();
    }
}
