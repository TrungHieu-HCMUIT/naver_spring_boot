package com.microservices.currency_exchange.common.error_handling.custom_exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("Invalid data");
    }
}
