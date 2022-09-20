package com.microservices.currency_exchange.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "exchange_value")
@Data
public class ExchangeValue {
    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal conversionMultiple;
    private Integer port;
}
