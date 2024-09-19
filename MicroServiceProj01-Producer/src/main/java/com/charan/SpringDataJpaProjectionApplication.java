package com.charan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringDataJpaProjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaProjectionApplication.class, args);
	}

}
