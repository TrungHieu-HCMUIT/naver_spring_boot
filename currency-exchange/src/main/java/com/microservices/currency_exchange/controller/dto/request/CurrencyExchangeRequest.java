package com.microservices.currency_exchange.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CurrencyExchangeRequest {
    @NotBlank(message = "Currency unit cannot be blank")
    String from;

    @NotBlank(message = "Currency unit cannot be blank")
    String to;
}
