package com.nit.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "demo") //prefix used in YML file
@EnableConfigurationProperties
//@Component  //Not recommended
@Configuration   //recommended
public class YMLConfigProps {

	/*
	//here veriable name and key name in YML file must be same
	private String welcomeMsg;
	private String greetMsg;
	*/
	
	/* WHY WE USED MAP HERE INSTREAD OF USING DIRECT VARIABLE NAME
	 --> here also one issue is there today 2 properties are there
	but in real-time project there is a possibility of having 30+ properties
	so we need to create 30+ variable in this class which is very bad(not recommended)
	to solve this issue we will create one map object and store all the properties in that map
	 object and user furthers
      */	
	//Variable name must be same as used in YAML 
	//like demo.properties.welcomeMsg=<Value>
	private Map<String,String> properties=new HashMap<>();
}
