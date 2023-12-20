package com.example.currencyconversionservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.currencyconversionservice.beans.CurrencyConversion;
import com.example.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable Long quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion > responseEntity = new RestTemplate().getForEntity(
				"http://currency-exchange:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,
				uriVariables);

		CurrencyConversion currencyConversion = responseEntity.getBody();
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(currencyConversion.getQuantity()*currencyConversion.getConversionMultiple());
		return currencyConversion;
		
		
 	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable Long quantity) {
		
		 

		CurrencyConversion currencyConversion = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(currencyConversion.getQuantity()*currencyConversion.getConversionMultiple());
		return currencyConversion;
		
		
 	}

}
