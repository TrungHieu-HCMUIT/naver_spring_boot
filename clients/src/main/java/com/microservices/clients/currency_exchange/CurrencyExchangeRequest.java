package com.microservices.clients.currency_exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeRequest {
    private String from;
    private String to;
}
