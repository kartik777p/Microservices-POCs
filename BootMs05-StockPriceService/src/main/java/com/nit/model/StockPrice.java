package com.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "STOCK_PRICE")
@Getter
@Setter
@AllArgsConstructor
public class StockPrice {
	
	@Id
	@Column(name = "STOCK_ID")
  private Integer stockId;
	
	@Column(name = "COMPANY_NAME")
  private String companyName;
	
	@Column(name = "COMPANY_PRICE")
  private double companyPrice;
}
