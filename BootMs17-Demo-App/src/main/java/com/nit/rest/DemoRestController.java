package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		System.out.println(env);
		//here we will getting on which port number our application is running
		String msg=env.getProperty("local.server.port");
		System.out.println(msg);
		return "Welcome to Spring Boot MS Application, which is running on port No :- "+msg;
	}

}
