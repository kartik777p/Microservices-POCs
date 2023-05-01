package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.IStockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceRestController {
	
	@Autowired
	private IStockPriceService stockPriceService;
	
	@Autowired
	private Environment env;
	
//	@GetMapping("/saveRecords")
//	public String saveAllCompanyDetails() {
//		String msg=stockPriceService.saveRecordToDB();
//		return msg;
//	}
	
	@GetMapping("stockPrice/{companyName}")
	public ResponseEntity<Double> findStockPrice(@PathVariable("companyName")String companyName)throws Exception {
		 double stockPrice=stockPriceService.getStockPrice(companyName);
		 //prove ribbon 
		 System.out.println(stockPrice+" From port Number :- "+env.getProperty("local.server.port"));
		 return new ResponseEntity<>(stockPrice, HttpStatus.OK);
	}
}
