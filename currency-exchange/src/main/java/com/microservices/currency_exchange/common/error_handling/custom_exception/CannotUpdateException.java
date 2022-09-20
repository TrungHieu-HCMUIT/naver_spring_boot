package com.microservices.currency_exchange.common.error_handling.custom_exception;

public class CannotUpdateException extends RuntimeException {
    public CannotUpdateException(String modelName) {
        super(String.format("Cannot update %s", modelName));
    }
}
