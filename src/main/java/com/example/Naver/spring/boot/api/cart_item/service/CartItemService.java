package com.example.naver.spring.boot.api.cart_item.service;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import com.example.naver.spring.boot.api.cart.service.CartService;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemAddToCartRequest;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsAddToCartRequest;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsFromCartParam;
import com.example.naver.spring.boot.api.cart_item.controller.dto.response.ItemInCartResponse;
import com.example.naver.spring.boot.api.cart_item.repository.CartItemMyBatisRepository;
import com.example.naver.spring.boot.api.cart_item.repository.CartItemRepository;
import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItem;
import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItemKey;
import com.example.naver.spring.boot.api.product.repository.entity.Product;
import com.example.naver.spring.boot.api.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartItemMyBatisRepository cartItemMyBatisRepository;

    private final CartService cartService;
    private final ProductService productService;

    public boolean addItemsToCart(Integer customerId, ItemsAddToCartRequest itemsAddToCart) {
        Cart cart = cartService.getOrCreateNewCart(customerId);
        for (ItemAddToCartRequest item: itemsAddToCart.getItems()) {
            Product product = productService.findProductById(item.getProductId());

            CartItem cartItem = new CartItem();
            cartItem.setId(new CartItemKey(cart.getId(), product.getId()));
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantityWished(item.getQuantity());
            cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            cartItem.setDateAdded(Date.from(Instant.now()));

            cartItemRepository.save(cartItem);
        }
        return true;
    }

    public List<ItemInCartResponse> getItemsFromCart(Integer customerId, ItemsFromCartParam itemsFromCartParam) {
        return cartItemMyBatisRepository.getItemsFromCart(
                customerId,
                itemsFromCartParam.getProductName().trim(),
                itemsFromCartParam.getOffset(),
                itemsFromCartParam.getLimit()
                );
    }

}
