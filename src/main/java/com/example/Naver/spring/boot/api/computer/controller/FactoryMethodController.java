package com.example.naver.spring.boot.api.computer.controller;

import com.example.naver.spring.boot.api.computer.service.FactoryMethodService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/factory-method")
public class FactoryMethodController extends BaseController {

    private final FactoryMethodService factoryMethodService;

    @GetMapping("/{type}")
    ResponseEntity<Object> getComputer(@PathVariable String type) {
        return successResponse(factoryMethodService.getComputerFromValue(type));
    }

}
