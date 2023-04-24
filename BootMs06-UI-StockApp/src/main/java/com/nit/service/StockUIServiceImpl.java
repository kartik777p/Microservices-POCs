package com.nit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockUIServiceImpl implements IStockUIService {
	
	@Override
	public String fetchTotalPrice(String companyName,int quantity) {
	//prepare endpoint having res service url
		//withOUT API GATEWAY
		String END_POINT="http://localhost:4444/calc/calculate/{companyName}/{quantity}";
		//declare variable at the top for method scope
		String response=null;
		//create webClient obj
		WebClient webClient=WebClient.create();
		//if company present will get its details
		try {
		 response=webClient. get()
				                 .uri(END_POINT,companyName,quantity)
				                 .retrieve()
				                 .bodyToMono(String.class)
				                 .block();
		}catch (Exception e) {
			response="Company Not Found in record";
		}//catch
		 return response;
	}//method
}//class
