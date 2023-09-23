package com.currency.exchange.service;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeValueRepository  extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findFirstByFromAndTo(String from , String to);
}
