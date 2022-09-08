package com.example.naver.spring.boot.aspect.error_handling.custom_exception;

public class CannotListException extends RuntimeException {
    public CannotListException(String modelName) {
        super(String.format("Cannot list %s", modelName));
    }
}
