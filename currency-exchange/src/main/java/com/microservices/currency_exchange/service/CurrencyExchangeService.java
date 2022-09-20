package com.microservices.currency_exchange.service;

import com.microservices.currency_exchange.common.Const;
import com.microservices.currency_exchange.common.error_handling.custom_exception.DataNotFoundException;
import com.microservices.currency_exchange.controller.dto.request.CurrencyExchangeRequest;
import com.microservices.currency_exchange.controller.dto.response.CurrencyExchangeResponse;
import com.microservices.currency_exchange.repository.CurrencyExchangeRepository;
import com.microservices.currency_exchange.repository.entity.ExchangeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeResponse getExchangeValue(CurrencyExchangeRequest request) {
        ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(request.getFrom(), request.getTo());

        if (exchangeValue == null) {
            throw new DataNotFoundException(Const.EntityName.EXCHANGE_VALUE);
        }

        return CurrencyExchangeResponse.builder()
                .from(exchangeValue.getFrom())
                .to(exchangeValue.getTo())
                .conversionMultiple(exchangeValue.getConversionMultiple())
                .build();
    }

}
