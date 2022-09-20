package com.microservices.currency_exchange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyExchangeConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
