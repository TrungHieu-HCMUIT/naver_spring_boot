package com.microservices.currency_calculation.controller.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyCalculationRequest {
    private String from;
    private String to;
    private BigDecimal amount;
}
