package com.example.naver.spring.boot.common.error_handling.custom_exception;

public class CannotCreateException extends RuntimeException {
    public CannotCreateException(String modelName) {
        super(String.format("Cannot create %s", modelName));
    }
}
