package com.nit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nit.service.IStockUIService;

@Controller
public class StockUIController {
	
	@Autowired
	private IStockUIService stockService;
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("StockUIController.showHomePage()");
		return "index";
	}

	@GetMapping("/getTotalPrice")
	public String getTotalPrice(HttpServletRequest req,Model model) {
		System.out.println("StockUIController.getTotalPrice()");
		//gather values from req param
		String companyName=req.getParameter("companyName");
		String quantity=req.getParameter("quantity");
		//call service method to get res as a msg
		String res=stockService.fetchTotalPrice(companyName,Integer.parseInt(quantity));
		//set to model attribute to display 
		model.addAttribute("msg", res);
		return "index";
	}
}
