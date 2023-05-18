package com.nit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import com.nit.model.Customer;
import com.nit.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService service;
	
	@PostMapping(value="/customers")
	public String saveCustomer(@RequestBody List<Customer> customers) {
		String returnMsg = service.addCustomerToKafka(customers);
		return returnMsg;
	}//saveCustomer
}//saveCustomer
