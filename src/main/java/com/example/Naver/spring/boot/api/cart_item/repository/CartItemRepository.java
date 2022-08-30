package com.example.naver.spring.boot.api.cart_item.repository;

import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItem;
import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {

}
