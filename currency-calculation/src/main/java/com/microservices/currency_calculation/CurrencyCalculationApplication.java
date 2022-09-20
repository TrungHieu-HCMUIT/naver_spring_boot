package com.microservices.currency_calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.microservices.clients"
)
public class CurrencyCalculationApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyCalculationApplication.class, args);
    }
}
