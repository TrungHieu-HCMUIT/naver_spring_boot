package com.example.naver.spring.boot.api.cart_item.repository.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemKey implements Serializable {

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "product_id")
    private int productId;
}
