package com.example.naver.spring.boot.api.customer.controller;

import com.example.naver.spring.boot.api.customer.controller.dto.request.CustomerCreateRequest;
import com.example.naver.spring.boot.api.customer.controller.dto.response.CustomerSimpleResponse;
import com.example.naver.spring.boot.api.customer.controller.dto.response.CustomerResponse;
import com.example.naver.spring.boot.api.customer.repository.entity.Customer;
import com.example.naver.spring.boot.api.customer.service.CustomerService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController extends BaseController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerCreateRequest request) {
        CustomerSimpleResponse response = modelMapper.map(customerService.createCustomer(request), CustomerSimpleResponse.class);
        return successResponse(response);
    }

    @GetMapping("/customers")
    public ResponseEntity<Object> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        List<CustomerSimpleResponse> customerResponses = customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerSimpleResponse.class))
                .collect(Collectors.toList());

        return successResponse(customerResponses);
    }
}
