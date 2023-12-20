package com.example.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

 import com.example.currencyexchangeservice.beans.ExchangeValue;
import com.example.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue= exchangeValueRepository.findByFromAndTo(from, to);
		
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return exchangeValue;	 
	}
}
