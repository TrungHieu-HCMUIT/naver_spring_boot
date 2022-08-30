package com.example.naver.spring.boot.api.customer.service;

import com.example.naver.spring.boot.api.cart.repository.entity.Cart;
import com.example.naver.spring.boot.api.customer.controller.dto.request.CustomerCreateRequest;
import com.example.naver.spring.boot.api.customer.repository.CustomerRepository;
import com.example.naver.spring.boot.api.customer.repository.entity.Customer;
import com.example.naver.spring.boot.common.Const;
import com.example.naver.spring.boot.common.error_handling.custom_exception.DataNotFoundException;
import com.example.naver.spring.boot.common.error_handling.custom_exception.InvalidRequestException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public Customer createCustomer(CustomerCreateRequest customerCreateRequest) {
        if (customerCreateRequest.getName() == null || customerCreateRequest.getPhone() == null) {
            throw new InvalidRequestException();
        }

        Customer newCustomer = new Customer();
        modelMapper.map(customerCreateRequest, newCustomer);

        return customerRepository.save(newCustomer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer findCustomer(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.CUSTOMER);
        }
        return customer.get();
    }

    public Customer updateCartToCustomer(Integer customerId, Cart cart) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.CUSTOMER);
        }
        Customer checkedCustomer = customer.get();
        checkedCustomer.setCart(cart);
        return customerRepository.save(checkedCustomer);
    }
}
