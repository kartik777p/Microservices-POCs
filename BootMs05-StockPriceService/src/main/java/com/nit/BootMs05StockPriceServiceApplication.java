package com.nit;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.nit.model.StockPrice;
import com.nit.repository.IStockPriceRepository;
import com.nit.rest.StockPriceRestController;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMs05StockPriceServiceApplication implements CommandLineRunner {
 
	@Autowired
	IStockPriceRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(BootMs05StockPriceServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BootMs05StockPriceServiceApplication.run()");
		StockPrice HCL=new StockPrice(101,"HCL",100.26);
		StockPrice TCS=new StockPrice(102,"TCS",200.26);
		StockPrice USIT=new StockPrice(103,"USIT",300.26);
		StockPrice NEO=new StockPrice(104,"NEO",400.26);
		List<StockPrice> list=Arrays.asList(HCL,NEO,TCS,USIT);
		List<StockPrice> listReturn=repo.saveAll(list);
	}

}
