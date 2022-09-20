package com.microservices.clients.currency_exchange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("currency-exchange")
public interface CurrencyExchangeClient {
    @GetMapping("api/v1/exchange/{from}_{to}")
    CurrencyExchangeResponse findExchangeValue(@PathVariable(name = "from") String from,
                                               @PathVariable(name = "to") String to);
}
