package com.nit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockPriceCalculationExceptionHander {
 
	@ExceptionHandler(value = CompanyNotFoundException.class)
	public ResponseEntity<String> handleCompanyNotFoundEx() {
		return new ResponseEntity<String>("Company Not Found ",HttpStatus.BAD_REQUEST);
	}
}
