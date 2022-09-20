package com.microservices.currency_exchange.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private int statusCode;
    @JsonProperty("err_key")
    private String key;
    private String message;

    public ErrorResponse(int statusCode, String key, String message) {
        this.statusCode = statusCode;
        this.key = key;
        this.message = message;
    }
}
