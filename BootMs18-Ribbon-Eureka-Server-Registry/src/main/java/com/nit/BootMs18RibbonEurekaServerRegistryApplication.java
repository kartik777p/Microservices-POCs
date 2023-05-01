package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMs18RibbonEurekaServerRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMs18RibbonEurekaServerRegistryApplication.class, args);
	}

}
