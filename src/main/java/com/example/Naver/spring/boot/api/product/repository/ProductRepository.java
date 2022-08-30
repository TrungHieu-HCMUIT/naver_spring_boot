package com.example.naver.spring.boot.api.product.repository;

import com.example.naver.spring.boot.api.product.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductsByPriceGreaterThan(BigDecimal price);
    List<Product> findProductsByPriceLessThan(BigDecimal price);
    List<Product> findProductsByPriceEquals(BigDecimal price);
}
