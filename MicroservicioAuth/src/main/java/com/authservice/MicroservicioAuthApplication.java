package com.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAuthApplication.class, args);
                System.out.println("Auth-Service");
	}

}
