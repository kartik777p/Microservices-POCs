package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.model.StockPrice;

public interface IStockPriceRepository extends JpaRepository<StockPrice, Integer> {
 
	//finder method
	public StockPrice findByCompanyName(String companyName);
}
