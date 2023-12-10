package com.electricity.connectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConnectionServiceApplication {

	public static void main(String[] args) {
		System.out.println("Hello World !");
		SpringApplication.run(ConnectionServiceApplication.class, args);
	}


}
