package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nit.client.HelloClient;

@RestController
public class HiServiceRestController {
	
	@Autowired
	private HelloClient helloClient;
	
	@GetMapping("/hi/{name}")
	public String sayHi(@PathVariable("name")String name) {
		String hiMsg="Hi";
		//interservice communication 
		String helloMsg=helloClient.invokeHello(name);
		//combine both res into single res and return
		return hiMsg+"--"+helloMsg;
	}
}
