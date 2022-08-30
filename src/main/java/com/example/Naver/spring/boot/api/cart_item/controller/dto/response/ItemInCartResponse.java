package com.example.naver.spring.boot.api.cart_item.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ItemInCartResponse {
    private int cartId;
    private int productId;
    private String name;
    private String type;
    private String size;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalAmount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateAdded;
}
