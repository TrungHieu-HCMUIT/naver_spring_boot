package com.microservices.currency_calculation.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyCalculationResponse {
    private Long id;
    private String from;
    private String to;
    private BigDecimal amount;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private String port;
}
