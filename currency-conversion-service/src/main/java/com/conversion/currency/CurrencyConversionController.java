package com.conversion.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from ,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("from", from);
        uriVariable.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
                .getForEntity("http://127.0.0.1:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class, uriVariable);
        CurrencyConversionBean response = responseEntity.getBody();
        return new CurrencyConversionBean(response.getId(), from, to ,response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from ,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {
        CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
        return new CurrencyConversionBean(response.getId(), from, to ,response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
