package com.example.naver.spring.boot.common.error_handling.custom_exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("Invalid data");
    }
}
