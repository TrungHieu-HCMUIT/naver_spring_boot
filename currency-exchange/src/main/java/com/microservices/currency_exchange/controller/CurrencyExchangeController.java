package com.microservices.currency_exchange.controller;

import com.microservices.currency_exchange.base.BaseController;
import com.microservices.currency_exchange.controller.dto.request.CurrencyExchangeRequest;
import com.microservices.currency_exchange.controller.dto.response.CurrencyExchangeResponse;
import com.microservices.currency_exchange.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CurrencyExchangeController extends BaseController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("v1/exchange")
    public ResponseEntity<Object> findTaxi(CurrencyExchangeRequest currencyExchangeRequest) {
        CurrencyExchangeResponse response = currencyExchangeService.getExchangeValue(currencyExchangeRequest);
        return successResponse(response);
    }
}
