package com.example.naver.spring.boot.api.product.controller;

import com.example.naver.spring.boot.api.product.controller.dto.request.ProductConditionParam;
import com.example.naver.spring.boot.api.product.controller.dto.request.ProductCreateRequest;
import com.example.naver.spring.boot.api.product.service.ProductService;
import com.example.naver.spring.boot.api.product.service.ProductServiceImpl;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController extends BaseController {

    private final ProductService productService;

    @GetMapping("/products")
    ResponseEntity<Object> getProducts(ProductConditionParam condition) {
        return successResponse(productService.getProductsByConditions(condition));
    }

    @PostMapping("/product")
    ResponseEntity<Object> createProducts(@RequestBody ProductCreateRequest productCreateRequest) {
        return successResponse(productService.createProduct(productCreateRequest));
    }

}
