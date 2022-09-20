package com.microservices.clients.currency_exchange;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class CurrencyExchangeResponse {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String port;
}
