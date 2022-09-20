package com.microservices.currency_exchange.service;

import com.microservices.clients.currency_exchange.CurrencyExchangeRequest;
import com.microservices.clients.currency_exchange.CurrencyExchangeResponse;
import com.microservices.currency_exchange.common.Const;
import com.microservices.currency_exchange.common.error_handling.custom_exception.DataNotFoundException;
import com.microservices.currency_exchange.repository.CurrencyExchangeRepository;
import com.microservices.currency_exchange.repository.entity.ExchangeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final Environment environment;

    public CurrencyExchangeResponse getExchangeValue(String from, String to) {
        ExchangeValue exchangeValue = currencyExchangeRepository.findByFromAndTo(from, to);

        if (exchangeValue == null) {
            throw new DataNotFoundException(Const.EntityName.EXCHANGE_VALUE);
        }

        return CurrencyExchangeResponse.builder()
                .id(exchangeValue.getId())
                .from(exchangeValue.getFrom())
                .to(exchangeValue.getTo())
                .conversionMultiple(exchangeValue.getConversionMultiple())
                .port(environment.getProperty("local.server.port"))
                .build();
    }

}
