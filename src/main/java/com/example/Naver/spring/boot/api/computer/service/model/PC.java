package com.example.naver.spring.boot.api.computer.service.model;

public class PC implements Computer {
    @Override
    public String getType() {
        return "PC";
    }
}
