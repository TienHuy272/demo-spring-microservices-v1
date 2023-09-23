package com.currency.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
        ExchangeValue exchangeValue = exchangeValueRepository.findFirstByFromAndTo(from, to);
        exchangeValue.setPort(port);
        return exchangeValue;
    }
}
