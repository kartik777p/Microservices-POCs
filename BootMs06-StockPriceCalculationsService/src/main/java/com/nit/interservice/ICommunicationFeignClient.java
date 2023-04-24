package com.nit.interservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Stock-PriceService" /*,url = "http://localhost:3333" */)
public interface ICommunicationFeignClient {
 
	@GetMapping("/price/stockPrice/{companyName}")
	public ResponseEntity<Double>  fetchStockPriceBasedOnCompanyName(@PathVariable("companyName")String companyName);
	
}
