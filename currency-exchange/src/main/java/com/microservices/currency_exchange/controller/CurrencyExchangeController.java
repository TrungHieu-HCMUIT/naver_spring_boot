package com.microservices.currency_exchange.controller;

import com.microservices.clients.currency_exchange.CurrencyExchangeRequest;
import com.microservices.clients.currency_exchange.CurrencyExchangeResponse;
import com.microservices.currency_exchange.base.BaseController;
import com.microservices.currency_exchange.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CurrencyExchangeController extends BaseController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("v1/exchange/{from}_{to}")
    public CurrencyExchangeResponse findExchangeValue(@PathVariable(name = "from") String from,
                                                      @PathVariable(name = "to") String to) {
        return currencyExchangeService.getExchangeValue(from, to);
    }

}
