package com.example.naver.spring.boot.api.customer.repository.entity;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private String name;
    private String address;

    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Cart cart;
}
