package com.example.naver.spring.boot.aspect.error_handling.custom_exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("Invalid data");
    }
}
