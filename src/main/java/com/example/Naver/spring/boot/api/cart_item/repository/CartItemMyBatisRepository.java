package com.example.naver.spring.boot.api.cart_item.repository;

import com.example.naver.spring.boot.api.cart_item.controller.dto.response.ItemInCartResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartItemMyBatisRepository {

    @Select("Select * " +
            "from CART_ITEM CI " +
            "join CART C on C.ID = CI.CART_ID " +
            "join PRODUCT P on P.ID = CI.PRODUCT_ID " +
            "join CUSTOMER CTM on CTM.CART_ID = C.ID " +
//            "where CTM.ID = #{customerId}" +
            "where P.NAME = #{productName} " +
            "limit #{limit} offset #{offset}")
    @Results(value = {
            @Result(column = "product_id", property = "productId"),
            @Result(column = "name", property = "name"),
            @Result(column = "type", property = "type"),
            @Result(column = "size", property = "size"),
            @Result(column = "price", property = "price"),
            @Result(column = "quantity_wished", property = "quantity"),
            @Result(column = "total_amount", property = "totalAmount"),
            @Result(column = "date_added", property = "dateAdded")
    })
    List<ItemInCartResponse> getItemsFromCart(int customerId, String productName, int offset, int limit);
}
