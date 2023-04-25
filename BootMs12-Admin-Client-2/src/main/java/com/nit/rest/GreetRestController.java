package com.nit.rest;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	public String greetmsg() {
		return "Good Morning ::";
	}
}
