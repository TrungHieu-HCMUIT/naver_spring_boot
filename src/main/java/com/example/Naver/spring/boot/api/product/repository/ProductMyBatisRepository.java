package com.example.naver.spring.boot.api.product.repository;

import com.example.naver.spring.boot.api.product.repository.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMyBatisRepository {
    @Select("select * from PRODUCT " +
            "where price > #{price}")
    List<Product> findProductsGreaterThan(BigDecimal price);

    @Select("select * from PRODUCT " +
            "where price < #{price}")
    List<Product> findProductsLessThan(BigDecimal price);

    @Select("select * from PRODUCT " +
            "where price = #{price}")
    List<Product> findProductsEqualsTo(BigDecimal price);

    @Select("select * from PRODUCT")
    List<Product> findAllProducts();
}
