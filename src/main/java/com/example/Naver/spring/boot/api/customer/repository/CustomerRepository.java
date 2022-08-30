package com.example.naver.spring.boot.api.customer.repository;

import com.example.naver.spring.boot.api.customer.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
