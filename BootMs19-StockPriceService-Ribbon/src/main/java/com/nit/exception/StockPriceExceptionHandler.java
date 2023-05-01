package com.nit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StockPriceExceptionHandler {
	
	//it  will not throw  exception i will give some  msg 
	@ExceptionHandler(value = CompanyNotFoundException.class)
	public ResponseEntity<String> CompanyNotFoundHander(){
		return new  ResponseEntity<>("Company Not Found in Records",HttpStatus.BAD_REQUEST);
	}

}
