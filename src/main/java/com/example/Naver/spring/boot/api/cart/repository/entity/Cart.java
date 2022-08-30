package com.example.naver.spring.boot.api.cart.repository.entity;

import com.example.naver.spring.boot.api.cart_item.repository.entity.CartItem;
import com.example.naver.spring.boot.api.customer.repository.entity.Customer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}
