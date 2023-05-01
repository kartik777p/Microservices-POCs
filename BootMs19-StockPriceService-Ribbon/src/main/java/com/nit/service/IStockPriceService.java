package com.nit.service;

public interface IStockPriceService {
	
	public String saveRecordToDB();
  
	public double getStockPrice(String companyName)throws Exception;
}
