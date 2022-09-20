package com.microservices.currency_exchange.controller.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyExchangeResponse {
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
