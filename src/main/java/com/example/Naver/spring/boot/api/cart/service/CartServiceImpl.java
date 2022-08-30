package com.example.naver.spring.boot.api.cart.service;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import com.example.naver.spring.boot.api.customer.repository.entity.Customer;
import com.example.naver.spring.boot.api.customer.service.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CustomerServiceImpl customerServiceImpl;

    @Override
    public Cart getOrCreateNewCart(int customerId) {
        Customer customer = customerServiceImpl.findCustomer(customerId);
        if (customer.getCart() == null) {
            Cart newCart = new Cart();
            Customer updatedCustomer = customerServiceImpl.updateCartToCustomer(customerId, newCart);
            return updatedCustomer.getCart();
        }
        return customer.getCart();
    }
}
