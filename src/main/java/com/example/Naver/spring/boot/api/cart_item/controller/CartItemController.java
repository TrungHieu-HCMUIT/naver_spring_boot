package com.example.naver.spring.boot.api.cart_item.controller;

import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsAddToCartRequest;
import com.example.naver.spring.boot.api.cart_item.controller.dto.request.ItemsFromCartParam;
import com.example.naver.spring.boot.api.cart_item.service.CartItemService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class CartItemController extends BaseController {

    private final CartItemService cartItemService;

    @PostMapping("/cart/add-items/{customerId}")
    public ResponseEntity<Object> addItemsToCart(@PathVariable Integer customerId, @RequestBody ItemsAddToCartRequest items) {
        return successResponse(cartItemService.addItemsToCart(customerId, items));
    }

    @GetMapping("/cart/items/{customerId}")
    public ResponseEntity<Object> getItemsFromCart(@PathVariable Integer customerId, ItemsFromCartParam param) {
        return successResponse(cartItemService.getItemsFromCart(customerId, param));
    }
}
