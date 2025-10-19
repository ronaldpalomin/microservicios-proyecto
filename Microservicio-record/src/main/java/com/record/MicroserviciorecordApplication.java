package com.record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "com.record.persistence")
public class MicroserviciorecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciorecordApplication.class, args);
	}

}
