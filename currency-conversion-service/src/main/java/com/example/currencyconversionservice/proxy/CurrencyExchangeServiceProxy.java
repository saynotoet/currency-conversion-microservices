package com.example.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currencyconversionservice.beans.CurrencyConversion;

//@FeignClient(name="currency-exchange", url="localhost:8000") -- it will always send request to instance running on 8000 
@FeignClient(name="currency-exchange") // it will do load balancing among different instances of service usinfg erueka
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to);
}
