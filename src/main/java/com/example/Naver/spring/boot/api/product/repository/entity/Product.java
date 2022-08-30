package com.example.naver.spring.boot.api.product.repository.entity;

import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String type;
    private String size;

    @Column(nullable = false)
    private BigDecimal price;

    @JsonIgnore
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL
    )
    private List<CartItem> cartItems;
}
