package com.example.naver.spring.boot.api.computer.service;

import java.util.Map;

public interface FactoryMethodService {
    Map<String, String> getComputerFromValue(String type);
}
