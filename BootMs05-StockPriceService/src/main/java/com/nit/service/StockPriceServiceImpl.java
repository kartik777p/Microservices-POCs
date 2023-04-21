package com.nit.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.exception.CompanyNotFoundException;
import com.nit.model.StockPrice;
import com.nit.repository.IStockPriceRepository;

@Service
public class StockPriceServiceImpl implements IStockPriceService {
	
   @Autowired
	private IStockPriceRepository stockPriceRepo;
	
	
	@Override
	public double getStockPrice(String companyName)throws Exception {
		//invoke repo method to fetch stockPrice details
		StockPrice stockPrice=stockPriceRepo.findByCompanyName(companyName);
		//handle null pointer exception if records is not present
		if(stockPrice==null) {
			throw new CompanyNotFoundException("CompanyNot found in Records");
		}
		//return stock price of the company
		return stockPrice.getCompanyPrice();
	}


	@Override
	public String saveRecordToDB() {
		StockPrice HCL=new StockPrice(101,"HCL",100.26);
		StockPrice TCS=new StockPrice(102,"TCS",200.26);
		StockPrice USIT=new StockPrice(103,"USIT",300.26);
		StockPrice NEO=new StockPrice(104,"NEO",400.26);
		List<StockPrice> list=Arrays.asList(HCL,NEO,TCS,USIT);
		List<StockPrice> listReturn=stockPriceRepo.saveAll(list);
		if(listReturn==null)
			return "Records not inserted into DB";
		else 
			return   "Records  inserted into DB";
	}
}
