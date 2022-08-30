package com.example.naver.spring.boot.api.cart_item.repository.entity;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import com.example.naver.spring.boot.api.product.repository.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "CART_ITEM")
public class CartItem {
    @EmbeddedId
    CartItemKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantityWished;

    @Temporal(TemporalType.DATE)
    private Date dateAdded;

    private BigDecimal totalAmount;
}
