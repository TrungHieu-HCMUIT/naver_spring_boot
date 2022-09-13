package com.example.naver.spring.boot.aspect.error_handling.custom_exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String modelName) {
        super(String.format("Cannot find %s", modelName));
    }
}
