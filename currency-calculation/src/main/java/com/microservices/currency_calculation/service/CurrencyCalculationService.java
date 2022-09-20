package com.microservices.currency_calculation.service;

import com.microservices.clients.currency_exchange.CurrencyExchangeClient;
import com.microservices.clients.currency_exchange.CurrencyExchangeResponse;
import com.microservices.currency_calculation.controller.dto.request.CurrencyCalculationRequest;
import com.microservices.currency_calculation.controller.dto.response.CurrencyCalculationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyCalculationService {

    private final CurrencyExchangeClient currencyExchangeClient;

    public CurrencyCalculationResponse getCalculatedAmount(CurrencyCalculationRequest request) {
        CurrencyExchangeResponse currencyExchangeResponse = currencyExchangeClient.findExchangeValue(request.getFrom(), request.getTo());

        return CurrencyCalculationResponse.builder()
                .id(currencyExchangeResponse.getId())
                .from(request.getFrom())
                .to(request.getTo())
                .conversionMultiple(currencyExchangeResponse.getConversionMultiple())
                .amount(request.getAmount())
                .totalCalculatedAmount(request.getAmount().multiply(currencyExchangeResponse.getConversionMultiple()))
                .port(currencyExchangeResponse.getPort())
                .build();
    }

}
