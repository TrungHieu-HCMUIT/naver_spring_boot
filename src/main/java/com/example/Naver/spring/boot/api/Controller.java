package com.example.Naver.spring.boot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class Controller {
    @GetMapping("/naver")
    public String getNaverString() {
        return "Hello NAVER";
    }

    @GetMapping("/likelion")
    public String getLikeLionString() {
        return "Hello LIKELION";
    }
}
