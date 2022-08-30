package com.example.naver.spring.boot.api.product.service;

import com.example.naver.spring.boot.api.product.controller.dto.request.ProductConditionParam;
import com.example.naver.spring.boot.api.product.controller.dto.request.ProductCreateRequest;
import com.example.naver.spring.boot.api.product.repository.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductCreateRequest productCreateRequest);
    List<Product> getProductsByConditions(ProductConditionParam productCondition);
    Product findProductById(Integer id);
}
