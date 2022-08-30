package com.example.naver.spring.boot.api.product.service;

import com.example.naver.spring.boot.api.product.controller.dto.request.ProductConditionParam;
import com.example.naver.spring.boot.api.product.controller.dto.request.ProductCreateRequest;
import com.example.naver.spring.boot.api.product.model.ConditionType;
import com.example.naver.spring.boot.api.product.repository.ProductMyBatisRepository;
import com.example.naver.spring.boot.api.product.repository.ProductRepository;
import com.example.naver.spring.boot.api.product.repository.entity.Product;
import com.example.naver.spring.boot.common.Const;
import com.example.naver.spring.boot.common.error_handling.custom_exception.DataNotFoundException;
import com.example.naver.spring.boot.common.error_handling.custom_exception.InvalidRequestException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMyBatisRepository productMyBatisRepository;
    private final ModelMapper modelMapper;

    public Product createProduct(ProductCreateRequest productCreateRequest) {
        if (productCreateRequest.getName() == null || productCreateRequest.getPrice() == null) {
            throw new InvalidRequestException();
        }

        Product newProduct = new Product();
        modelMapper.map(productCreateRequest, newProduct);
        return productRepository.save(newProduct);
    }

    public List<Product> getProductsByConditions(ProductConditionParam productCondition) {
        Double price = productCondition.getPrice();
        String condition = productCondition.getCondition();

        if (price == null && condition == null) { // No params
            return productMyBatisRepository.findAllProducts();
        }
        else if (price == null || condition == null){ // Params is invalid
            throw new InvalidRequestException();
        }

        ConditionType conditionType = ConditionType.fromString(productCondition.getCondition().toLowerCase());
        if (conditionType == null) {
            throw new InvalidRequestException();
        }

        BigDecimal bigDecimalPrice = BigDecimal.valueOf(price);
        List<Product> products = new ArrayList<>();

        switch (conditionType) {
            case GREATER_THAN:
                products = productMyBatisRepository.findProductsGreaterThan(bigDecimalPrice);
                break;
            case LESS_THAN:
                products = productMyBatisRepository.findProductsLessThan(bigDecimalPrice);
                break;
            case EQUAL:
                products = productMyBatisRepository.findProductsEqualsTo(bigDecimalPrice);
                break;
        }
        return products;
    }

    public Product findProductById(Integer id) {
        if (id == null) {
            throw new InvalidRequestException();
        }
        var product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.PRODUCT);
        }
        return product.get();
    }
}
