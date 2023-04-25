package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.config.YMLConfigProps;
import com.nit.containts.AppContaints;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private YMLConfigProps configProps;

	@GetMapping("/welcome")
	public String showWelcome() {
		//way 1 )hard-code into java file (not-recomanded)
		//return "Welcome to India :: ";
		
		//Way 2) read values from YML file
		/*String welcomeMsg=configProps.getWelcomeMsg();
		String greetMsg=configProps.getGreetMsg();
		*/
		
	/*	//Way 3) read values from configProperties(Map object) ->good but not great
		String welcomeMsg=configProps.getProperties().get("welcomeMsg");  //here we are hardcoding the key which is not good 
				String greetMsg=configProps.getProperties().get("greetMsg");   */
		
		//Way 4 read values from Map object by using AppContaints (Good and great)
		String welcomeMsg=configProps.getProperties().get(AppContaints.WELCOME_MSG); //here we have created one Special class to hold the key as a static  and using that key By that class name
		String greetMsg=configProps.getProperties().get(AppContaints.GREET_MSG);
		
		return welcomeMsg+" "+greetMsg;  
	}
}
