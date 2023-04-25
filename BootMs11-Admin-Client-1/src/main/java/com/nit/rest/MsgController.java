package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.GET;

@RestController
public class MsgController {
	
	@GetMapping("/msg")
	public String showMsg() {
		return "Hello...!!";
	}

}
