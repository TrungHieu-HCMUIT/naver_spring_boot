package com.microservices.currency_exchange.common.error_handling.custom_exception;

public class CannotCreateException extends RuntimeException {
    public CannotCreateException(String modelName) {
        super(String.format("Cannot create %s", modelName));
    }
}
