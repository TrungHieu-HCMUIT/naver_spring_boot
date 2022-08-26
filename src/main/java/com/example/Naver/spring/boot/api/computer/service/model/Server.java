package com.example.naver.spring.boot.api.computer.service.model;

public class Server implements Computer {
    @Override
    public String getType() {
        return "Server";
    }
}
