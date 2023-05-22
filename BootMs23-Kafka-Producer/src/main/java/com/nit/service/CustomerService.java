package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nit.constants.KafkaConstants;
import com.nit.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private KafkaTemplate<String,Customer> kafkaTemplate;

	/*
	 This method is used to publish a msg to a kafka topic
	 */
	public String addCustomerToKafka(List<Customer> customers) {
		//check list empty or not
		if(!customers.isEmpty()) {
			for(Customer cust: customers) {
				//store msg to kafka topic
				kafkaTemplate.send(KafkaConstants.TOPIC, cust);
				System.out.println("************************msg is published to a kafka topic *************");
			}//for
		}//if
		return "Customer records added to kafka Queue Sucessfully...";
	}//addCustomerToKafka
	
	
}
