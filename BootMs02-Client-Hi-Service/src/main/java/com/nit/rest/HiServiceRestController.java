package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiServiceRestController {
	
	@GetMapping("/hi/{name}")
	public String sayHi(@PathVariable("name")String name) {
		return "Hi ,"+name+" How Are You ??";
	}

}
