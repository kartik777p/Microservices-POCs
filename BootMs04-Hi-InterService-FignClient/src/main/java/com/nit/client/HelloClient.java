package com.nit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//do not use url here bcz url can be change time to time 
//it will give some problem

@FeignClient(name = "Hello-Service")  
public interface HelloClient {
	
	@GetMapping("/hello/{name}")
	public String invokeHello(@PathVariable("name")String name);
  
}
