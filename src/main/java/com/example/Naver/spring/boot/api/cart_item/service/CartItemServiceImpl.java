package com.example.naver.spring.boot.api.cart_item.service;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import com.example.naver.spring.boot.api.cart.service.CartServiceImpl;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemAddToCartRequest;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsAddToCartRequest;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsFromCartParam;
import com.example.naver.spring.boot.api.cart_item.controller.dto.response.ItemInCartResponse;
import com.example.naver.spring.boot.api.cart_item.repository.CartItemMyBatisRepository;
import com.example.naver.spring.boot.api.cart_item.repository.CartItemRepository;
import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItem;
import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItemKey;
import com.example.naver.spring.boot.api.product.repository.entity.Product;
import com.example.naver.spring.boot.api.product.service.ProductServiceImpl;
import com.example.naver.spring.boot.common.error_handling.custom_exception.InvalidRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartItemMyBatisRepository cartItemMyBatisRepository;

    private final CartServiceImpl cartServiceImpl;
    private final ProductServiceImpl productServiceImpl;

    @Override
    public boolean addItemsToCart(Integer customerId, ItemsAddToCartRequest itemsAddToCart) {
        Cart cart = cartServiceImpl.getOrCreateNewCart(customerId);
        for (ItemAddToCartRequest item : itemsAddToCart.getItems()) {
            Product product = productServiceImpl.findProductById(item.getProductId());

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

    @Override
    public List<ItemInCartResponse> getItemsFromCart(Integer customerId, ItemsFromCartParam itemsFromCartParam) {
        if (itemsFromCartParam.getProductName() == null
                && itemsFromCartParam.getLimit() == null
                && itemsFromCartParam.getOffset() == null) {
            return cartItemMyBatisRepository.getItemsFromCartWithoutParam(customerId);
        } else if (
                itemsFromCartParam.getProductName() == null
                        || itemsFromCartParam.getLimit() == null
                        || itemsFromCartParam.getOffset() == null
        ) {
            throw new InvalidRequestException();
        }

        return cartItemMyBatisRepository.getItemsFromCartWithParam(
                customerId,
                itemsFromCartParam.getProductName().trim(),
                itemsFromCartParam.getOffset(),
                itemsFromCartParam.getLimit()
        );
    }

}
