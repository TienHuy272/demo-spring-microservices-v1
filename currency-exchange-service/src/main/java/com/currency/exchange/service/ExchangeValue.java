package com.currency.exchange.service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExchangeValue {
    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from ;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
}
