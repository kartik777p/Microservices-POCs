package com.nit.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


import com.nit.constants.KafkaConstants;
import com.nit.model.Customer;

//@Configuration
public class KafkaProducerConfig {
	
	/*
	 * This method is used for DefaultKafkaProducerFactory bean obj
	 */
	@Bean
	public ProducerFactory<String,Customer> getDefaultKafkaProducerFactory(){
		//Set configurations properties to map obj
		Map<String,Object> configProperties=new HashMap<>();
		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.HOST);
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		//create DeafultProducerFactory  obj having all this details and return
		return new DefaultKafkaProducerFactory<>(configProperties);	
	}//getDefaultKafkaProducerFactory

	/*
	 * This method is used to create  kafkaTemplate bean obj
	 */

	@Bean(name = "kafkaTemplate")
	 public KafkaTemplate<String,Customer> getKafkaTemplate(){
		 return new KafkaTemplate<>(getDefaultKafkaProducerFactory());
	}//getKafkaTemplate
}
