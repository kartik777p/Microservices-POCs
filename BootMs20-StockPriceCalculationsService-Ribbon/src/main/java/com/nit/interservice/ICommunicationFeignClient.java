package com.nit.interservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCK-PRICESERVICE" /*,url = "http://localhost:3333" */)
@RibbonClient(name = "STOCK-PRICESERVICE")
public interface ICommunicationFeignClient {
 
	@GetMapping("/price/stockPrice/{companyName}")
	public ResponseEntity<Double>  fetchStockPriceBasedOnCompanyName(@PathVariable("companyName")String companyName);
	
}
