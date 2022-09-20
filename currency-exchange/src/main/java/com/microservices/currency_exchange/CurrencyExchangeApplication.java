package com.microservices.currency_exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.microservices.clients"
)
public class CurrencyExchangeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeApplication.class, args);
    }
}
