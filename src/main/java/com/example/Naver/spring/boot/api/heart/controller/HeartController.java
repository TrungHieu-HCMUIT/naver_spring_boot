package com.example.naver.spring.boot.api.heart.controller;

import com.example.naver.spring.boot.api.employee.service.EmployeeService;
import com.example.naver.spring.boot.api.heart.service.HeartService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likelion")
@RequiredArgsConstructor
public class HeartController extends BaseController {

    private final HeartService heartService;

    @GetMapping("/heart")
    public void logHeart() {
        heartService.printLog();
    }
}
