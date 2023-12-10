package com.electricity.chartingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class ChartingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartingServiceApplication.class, args);
	}

}
