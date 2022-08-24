package com.example.naver.spring.boot.common.error_handling.custom_exception;

public class CannotUpdateException extends RuntimeException {
    public CannotUpdateException(String modelName) {
        super(String.format("Cannot update %s", modelName));
    }
}
