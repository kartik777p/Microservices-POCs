//TicketBookingController.java
package com.nt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TicketBookingController {

	@GetMapping("/booking")
	@HystrixCommand(fallbackMethod = "dummyBookTickets")
	public  String   bookTickets() {
		System.out.println("TicketBookingController.bookTickets()");
		int n=10/0;
			return "Tickets booked sucessfully";
		}//method
	
	
	public  String dummyBookTickets() {   // this method should not have params
		System.out.println("TicketBookingController.dummyBookTickets()");
		return " Sorry for inconvience .... some problem in ticket booking";
	}
	
}//class
	
