package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nit.exception.CompanyNotFoundException;
import com.nit.interservice.ICommunicationFeignClient;

@RestController
public class StockPriceCalculationsRestController {

	@Autowired
	private ICommunicationFeignClient feignClient;

	@GetMapping("stockPriceCalc/{companyName}/{quantity}")
	public ResponseEntity<?> calcAmtOfTheStocks(@PathVariable("companyName") String companyName,
			                                                                                @PathVariable("quantity") int quantity){
		ResponseEntity<?> resEntity=null;
		Double totalPrice=null;
		try {
		//get the response from 2nd service
		//here our resEntity holding responseEntity<double>
		resEntity=feignClient.fetchStockPriceBasedOnCompanyName(companyName);
		//check the status code
		if(resEntity.getStatusCodeValue()==200) {
			//gather that stock value by type casting bcz resEntity can hold any type as we are using wildcard generic
			Double stockPrice=(Double) resEntity.getBody();
			//now do stock calculations logic
			totalPrice=stockPrice*quantity;
			//build resEntity obj having response(String type)
			String response="Total Amount of the "+quantity+" Stocks of  "+companyName+" is :- "+totalPrice;
			//here our responseEntity holding ResponseEntity<String> 
			//to avoid
			return new ResponseEntity<String>(response,HttpStatus.OK);
		     }
		}catch (Exception e) {
			//send msg company not found in res entity
			resEntity=new ResponseEntity<>("Company Not found in record", HttpStatus.BAD_REQUEST);
		}
		return resEntity;
		/*
		Double totalAmt=null;
		//get the res from 2nd service
		ResponseEntity<Double> resEntity = fignClient.fetchStockPriceBasedOnCompanyName(companyName);
		//get the status code and write logic
		int statusCode=resEntity.getStatusCodeValue();
		if(statusCode==200) {
			//get the body(data)
			double stockPrice=resEntity.getBody();
			//calculate total amt 
			totalAmt=stockPrice*quantity;
			//build res entity obj having response
			String response="Total Amount of the "+quantity+" Stocks of  "+companyName+" is :- "+totalAmt;
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}//if
		return new ResponseEntity<String>("Company Not Found",HttpStatus.BAD_REQUEST);
*/
	
	}
}
