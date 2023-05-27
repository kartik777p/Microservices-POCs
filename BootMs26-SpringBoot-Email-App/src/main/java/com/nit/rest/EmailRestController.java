package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.MailService;

@RestController
public class EmailRestController {

	@Autowired
	private MailService service;
	
	@GetMapping("/send")
	public String sendMail() {
		String sub="Naresh IT || Mail Application ";
		String body="Welcome to Naresh IT............";
		String to="kartik777p@gmail.com";
		//use service class to send email
		boolean isSend = service.sendMail(sub, body, to);
		if(isSend) {
			return "Email is send Sucessfully...........";
		}
		return "Email failed to send";
	}
}
